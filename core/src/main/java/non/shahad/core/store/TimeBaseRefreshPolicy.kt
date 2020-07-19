package non.shahad.core.store

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.time.*

@ExperimentalTime
class TimeBasedRefreshPolicy constructor(
    private val expiration: Duration = DEFAULT_EXPIRATION,
    private val timeSource: TimeSource = TimeSource.Monotonic
) : RefreshPolicy {

    init {
        require(expiration.isPositive()) { "Expiration for refresh policy must be positive." }
    }

    private val lock = Mutex()

    private val refreshLog = mutableMapOf<RefreshScope, TimeMark>()

    override suspend fun shouldRefresh(refreshScope: RefreshScope): Boolean {
        return lock.withLock {
            val expirationMark = refreshLog[refreshScope]
            expirationMark == null || (expirationMark + expiration).hasPassedNow()
        }
    }

    override suspend fun onRefreshed(refreshScope: RefreshScope) {
        lock.withLock {
            val expirationMark = refreshLog[refreshScope]
            if (expirationMark != null) {
                refreshLog[refreshScope] = expirationMark + expirationMark.elapsedNow()
            } else {
                refreshLog[refreshScope] = timeSource.markNow()
            }
        }
    }

    /**
     * Clears the refresh logs for all [RefreshScope]s which means [shouldRefresh] will return true
     * for all [RefreshScope]s until [onRefreshed] is invoked again.
     */
    suspend fun reset() {
        lock.withLock { refreshLog.clear() }
    }

    companion object {
        val DEFAULT_EXPIRATION = 5.minutes
    }
}
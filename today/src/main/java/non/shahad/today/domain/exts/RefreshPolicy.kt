package non.shahad.today.domain.exts

interface RefreshPolicy {
    /**
     * Returns whether the store should fetch data from the network at the start of the stream.
     * @param refreshScope a string that represents a specific data set whose refresh policy
     * the consumer is concerned with.
     */
    suspend fun shouldRefresh(refreshScope: RefreshScope): Boolean

    /**
     * Called when a new [StoreResponse.Data] with [ResponseOrigin.Fetcher] is emitted from the stream.
     * @param refreshScope a string that represents a specific data set that has just been refreshed.
     */
    suspend fun onRefreshed(refreshScope: RefreshScope)

}

/**
 * A string representation of a specific data set which the [RefreshPolicy] is concerned with.
 */
inline class RefreshScope(val scope: String)
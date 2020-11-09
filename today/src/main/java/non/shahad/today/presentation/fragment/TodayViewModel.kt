package non.shahad.today.presentation.fragment

import io.reactivex.disposables.CompositeDisposable
import non.shahad.core.mvi.MVIViewModel
import non.shahad.today.domain.repository.TodayRepository
import non.shahad.today.presentation.fragment.viewstates.TodayViewEffect
import non.shahad.today.presentation.fragment.viewstates.TodayViewEvent
import non.shahad.today.presentation.fragment.viewstates.TodayViewState
import timber.log.Timber
import javax.inject.Inject

class TodayViewModel @Inject constructor(
    private val useCase: TodayRepository
): MVIViewModel<TodayViewState, TodayViewEffect, TodayViewEvent>() {

    private var disposable: CompositeDisposable = CompositeDisposable()

    init {
        streamedHeadlines()
    }

    private fun streamedHeadlines(){
        disposable.add(
                useCase.cacheOrFreshHeadlines()
                    .subscribe { data, throwable ->
                        Timber.e(throwable)
                        Timber.d("$data")
                    }
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }

}
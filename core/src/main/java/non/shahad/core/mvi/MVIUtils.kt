package non.shahad.core.mvi

internal interface ViewModelContract<EVENT> {
    fun process(viewEvent: EVENT)
}

class NoObserverAttachedException(message: String) : Exception(message)
package com.example.melitest.utils

sealed class UIState {
    object Loading : UIState()
    object Empty : UIState()
    data class Error(val message: String?) : UIState() {
        constructor(throwable: Throwable) : this(throwable.message)
    }

    data class Success<T>(var data: T?) : UIState()

}


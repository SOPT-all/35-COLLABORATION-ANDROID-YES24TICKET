package org.andsopt.android.yes24ticket.util.view

sealed interface LoadState {
    data object Idle : LoadState

    data object Loading : LoadState

    data object Success : LoadState

    data object Fail : LoadState
}

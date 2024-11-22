package org.andsopt.android.yes24ticket.presentation.ui.dummy.state

import org.andsopt.android.yes24ticket.util.base.UiState
import org.andsopt.android.yes24ticket.util.view.LoadState

data class DummyUiState(
    val dummyString: String = "",
    val dummySecondString: String = "",
    val loadState: LoadState = LoadState.Idle
): UiState

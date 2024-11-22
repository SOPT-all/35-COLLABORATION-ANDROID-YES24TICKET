package org.andsopt.android.yes24ticket.presentation.ui.dummy

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.andsopt.android.yes24ticket.presentation.ui.dummy.state.DummyUiState
import org.andsopt.android.yes24ticket.util.base.UiState
import org.andsopt.android.yes24ticket.util.view.LoadState

@Composable
fun DummyRoute(
    viewModel: DummyViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.apply {
            getDummyData()
            getDummyExampleDate()
        }
    }

    when (val state: UiState = uiState) {
        is DummyUiState -> {
            when (state.loadState) {
                LoadState.Idle -> Unit

                LoadState.Loading -> Unit

                LoadState.Success -> {
                    DummyScreen(
                        dummyData = state.dummyString,
                        dummySecondData = state.dummySecondString,
                    )
                }

                LoadState.Fail -> Unit
            }
        }
    }
}

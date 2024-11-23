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
    val yes24UiState by viewModel.dummyYes24UiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.apply {
            getDummyData()
            getDummyExampleDate()
        }
    }

    // LoadState를 이용한 방식
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

    // combine을 이용한 방식
    DummyScreen(
        dummyData = yes24UiState.dummyYes,
        dummySecondData = yes24UiState.dummy24.toString()
    )
}

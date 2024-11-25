package org.andsopt.android.yes24ticket.presentation.ui.dummy

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.andsopt.android.yes24ticket.presentation.ui.dummy.state.DummyYes24UiState

@Composable
fun DummyRoute(
    viewModel: DummyViewModel = hiltViewModel(),
) {
    val dummyYes24UiState by viewModel.dummyYes24UiState.collectAsStateWithLifecycle()

    when (dummyYes24UiState) {
        is DummyYes24UiState.Success -> {
            val dummyAData = (dummyYes24UiState as DummyYes24UiState.Success).dummyA
            val dummyBData = (dummyYes24UiState as DummyYes24UiState.Success).dummyB

            DummyScreen(
                dummyData = dummyAData.dummyId,
                dummySecondData = dummyBData.dummyB,
            )
        }

        is DummyYes24UiState.Loading -> Unit
        is DummyYes24UiState.Error -> Unit
    }
}

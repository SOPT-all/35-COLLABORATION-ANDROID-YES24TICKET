package org.andsopt.android.yes24ticket.presentation.ui.dummy

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DummyRoute(
    paddingValues: PaddingValues,
    viewModel: DummyViewModel = hiltViewModel(),
) {
    LaunchedEffect(Unit) {
        viewModel.getDummyData()
    }

    DummyScreen(paddingValues = paddingValues)
}

package org.andsopt.android.yes24ticket.presentation.ui.dummy

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.andsopt.android.yes24ticket.presentation.ui.component.DummyComponent
import org.andsopt.android.yes24ticket.ui.theme.YES24TICKETTheme

@Composable
fun DummyScreen(
    paddingValues: PaddingValues
) {
    Column(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxSize()
    ) {
        Text(
            text = "YES24TICKET",
            fontSize = 50.sp
        )

        DummyComponent(message = "우리 팀 화이팅")
    }
}

@Preview
@Composable
fun DummyScreenPreview() {
    YES24TICKETTheme {
        DummyScreen(paddingValues = PaddingValues(16.dp))
    }
}
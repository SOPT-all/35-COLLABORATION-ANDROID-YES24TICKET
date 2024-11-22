package org.andsopt.android.yes24ticket.presentation.ui.dummy

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import org.andsopt.android.yes24ticket.presentation.ui.component.DummyComponent
import org.andsopt.android.yes24ticket.ui.theme.YES24TICKETTheme

@Composable
fun DummyScreen(
    dummyData: String,
    dummySecondData: String,
) {
    Column(
        modifier =
            Modifier
                .fillMaxSize(),
    ) {
        Text(
            text = dummyData,
            fontSize = 50.sp,
        )

        DummyComponent(message = dummySecondData)
    }
}

@Preview
@Composable
fun DummyScreenPreview() {
    YES24TICKETTheme {
        DummyScreen(
            dummyData = "YES24TICKET",
            dummySecondData = "우리 팀 화이팅"
        )
    }
}

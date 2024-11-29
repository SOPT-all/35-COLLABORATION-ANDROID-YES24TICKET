package org.andsopt.android.yes24ticket.presentation.ui.ticket.detail.component

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.andsopt.android.yes24ticket.R
import org.andsopt.android.yes24ticket.ui.theme.YES24TICKETTheme
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme
import org.andsopt.android.yes24ticket.util.compose.topBorder

@Composable
fun TicketDetailReserveButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    @StringRes buttonText: Int = R.string.ticket_detail_reservation_button,
) {
    Column(
        modifier =
            modifier
                .fillMaxWidth()
                .background(Yes24TicketTheme.colorScheme.white)
                .clickable { onClick() }
                .topBorder(color = Yes24TicketTheme.colorScheme.gray200, height = 1f)
                .padding(vertical = 12.dp, horizontal = 14.dp),
    ) {
        Text(
            text = stringResource(buttonText),
            modifier =
                Modifier
                    .fillMaxWidth()
                    .background(color = Yes24TicketTheme.colorScheme.red100, shape = RoundedCornerShape(2.dp))
                    .border(width = 1.dp, color = Yes24TicketTheme.colorScheme.red200, shape = RoundedCornerShape(2.dp))
                    .padding(vertical = 12.dp),
            textAlign = TextAlign.Center,
            color = Yes24TicketTheme.colorScheme.white,
            style = Yes24TicketTheme.typography.buttonExtraBold18,
        )
    }
}

@Preview
@Composable
private fun TicketDetailReserveButtonPreview() {
    YES24TICKETTheme {
        TicketDetailReserveButton()
    }
}

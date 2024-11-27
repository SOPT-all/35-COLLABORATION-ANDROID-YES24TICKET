package org.andsopt.android.yes24ticket.presentation.ui.ticket.reservation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.andsopt.android.yes24ticket.R
import org.andsopt.android.yes24ticket.domain.model.RemainingSeat
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme

@Composable
fun SeatItem(
    remainingSeat: RemainingSeat,
    modifier: Modifier = Modifier,
) {
    val textColor =
        if (remainingSeat.remainingSeats.toInt() > 0) {
            Yes24TicketTheme.colorScheme.gray700
        } else {
            Yes24TicketTheme.colorScheme.gray250
        }
    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = remainingSeat.type,
                style = Yes24TicketTheme.typography.bodyMedium13,
                color = textColor,
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(R.string.n_seat, remainingSeat.remainingSeats),
                style = Yes24TicketTheme.typography.bodyMedium13,
                color = textColor,
            )
        }
        HorizontalDivider(
            modifier = Modifier.padding(top = 2.dp),
            color = Yes24TicketTheme.colorScheme.gray250,
        )
    }
}

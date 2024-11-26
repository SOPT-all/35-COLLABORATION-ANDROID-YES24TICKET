package org.andsopt.android.yes24ticket.presentation.ui.ticket.reservation.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import org.andsopt.android.yes24ticket.R
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme
import org.andsopt.android.yes24ticket.util.compose.noRippleClickable

@Composable
fun CalendarMonthRow(
    onNextClicked: () -> Unit,
    onPrevClicked: () -> Unit,
    year: Int,
    month: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            modifier =
                Modifier.noRippleClickable {
                    if (month == 12) onPrevClicked()
                },
            imageVector =
                if (month == 12) {
                    ImageVector.vectorResource(R.drawable.ic_reservation_arrow_left_24)
                } else {
                    ImageVector.vectorResource(R.drawable.ic_reservation_arrow_left_disabled_24)
                },
            contentDescription = stringResource(R.string.previous_month),
            tint = Color.Unspecified,
        )
        Text(
            text = "$year. $month",
            style = Yes24TicketTheme.typography.titleSemiBold22,
            color = Yes24TicketTheme.colorScheme.gray900,
            modifier = Modifier.padding(horizontal = 10.dp),
        )
        Icon(
            modifier =
                Modifier.noRippleClickable {
                    if (month == 11) onNextClicked()
                },
            imageVector =
                if (month == 11) {
                    ImageVector.vectorResource(R.drawable.ic_reservation_arrow_right_24)
                } else {
                    ImageVector.vectorResource(R.drawable.ic_reservation_arrow_right_disabled_24)
                },
            contentDescription = stringResource(R.string.next_month),
            tint = Color.Unspecified,
        )
    }
}

package org.andsopt.android.yes24ticket.presentation.ui.ticket.reservation.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import org.andsopt.android.yes24ticket.R
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme

@Composable
fun SelectTimeButton(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = stringResource(R.string.select),
            style = Yes24TicketTheme.typography.buttonBold13,
            color = Yes24TicketTheme.colorScheme.white,
            modifier =
                Modifier
                    .padding(vertical = 8.dp)
                    .padding(start = 16.dp),
        )
        Icon(
            modifier = Modifier.padding(end = 11.dp, start = 8.dp),
            imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_right_16),
            contentDescription = null,
            tint = Yes24TicketTheme.colorScheme.white,
        )
    }
}

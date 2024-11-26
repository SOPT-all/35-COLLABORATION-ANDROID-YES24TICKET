package org.andsopt.android.yes24ticket.presentation.ui.ticket.detail.component

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.andsopt.android.yes24ticket.R
import org.andsopt.android.yes24ticket.ui.theme.YES24TICKETTheme
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme
import org.andsopt.android.yes24ticket.util.compose.bottomBorder
import org.andsopt.android.yes24ticket.util.compose.dashedBottomBorder
import org.andsopt.android.yes24ticket.util.compose.noRippleClickable

@Composable
fun TicketDetailExpandableRow(
    @StringRes titleText: Int,
    isExpanded: Boolean,
    modifier: Modifier = Modifier,
    onChangeExpanded: () -> Unit = {},
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()

    ) {
        ExpandableTitle(
            titleText = titleText,
            isExpanded = isExpanded,
            modifier = Modifier
                .fillMaxWidth()
                .noRippleClickable { onChangeExpanded() }
        )

        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = isExpanded
        ) {
            content()
        }
    }
}

@Composable
private fun ExpandableTitle(
    @StringRes titleText: Int,
    isExpanded: Boolean,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = if (!isExpanded) {
            modifier.bottomBorder(color = Yes24TicketTheme.colorScheme.gray200, height = 1f)
        } else {
            modifier.dashedBottomBorder(color = Yes24TicketTheme.colorScheme.gray200, strokeWidth = 1.dp)
        },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(titleText),
            modifier = Modifier
                .padding(start = 10.dp)
                .padding(vertical = 13.dp),
            color = Yes24TicketTheme.colorScheme.gray700,
            style = Yes24TicketTheme.typography.titleBold15
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = if (!isExpanded) {
                ImageVector.vectorResource(R.drawable.ic_arrow_down_16)
            } else {
                ImageVector.vectorResource(R.drawable.ic_arrow_up_16)
            },
            modifier = Modifier
                .padding(end = 7.dp),
            contentDescription = if (!isExpanded) {
                stringResource(R.string.ticket_detail_expand_description)
            } else {
                stringResource(R.string.ticket_detail_close_description)
            },
            tint = Yes24TicketTheme.colorScheme.gray400
        )
    }
}

@Preview
@Composable
private fun TicketDetailExpandableRowPreview() {
    YES24TICKETTheme {

    }
}
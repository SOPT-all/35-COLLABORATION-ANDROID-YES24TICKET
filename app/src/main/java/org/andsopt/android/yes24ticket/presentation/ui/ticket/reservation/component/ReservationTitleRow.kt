package org.andsopt.android.yes24ticket.presentation.ui.ticket.reservation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.andsopt.android.yes24ticket.R
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme
import org.andsopt.android.yes24ticket.util.compose.noRippleClickable

@Composable
fun ReservationTitleRow(
    onCloseIconClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val triWidth =
        with(LocalDensity.current) {
            12.dp.toPx()
        }
    val reserveBackgroundColor = Yes24TicketTheme.colorScheme.coolGray300

    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .background(Yes24TicketTheme.colorScheme.coolGray100),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = stringResource(R.string.reserve),
            modifier =
                Modifier
                    .weight(4.5f)
                    .fillMaxHeight()
                    .clipToBounds()
                    .drawBehind {
                        drawRect(
                            size =
                                size.copy(
                                    width = size.width - triWidth + 1,
                                ),
                            color = reserveBackgroundColor,
                        )
                        val path =
                            Path().apply {
                                moveTo(size.width - triWidth, 0f)
                                lineTo(size.width, size.height / 2)
                                lineTo(size.width - triWidth, size.height)
                                close()
                            }
                        drawPath(
                            path = path,
                            color = reserveBackgroundColor,
                        )

                        val borderPath =
                            Path().apply {
                                moveTo(size.width - triWidth, 0f)
                                lineTo(size.width - 3, size.height / 2)
                                lineTo(size.width - triWidth, size.height)
                            }
                        drawPath(
                            path = borderPath,
                            color = Color.Black,
                            style = Stroke(width = 1.dp.toPx()),
                        )
                    }.padding(vertical = 11.dp),
            style = Yes24TicketTheme.typography.titleBold15,
            color = Yes24TicketTheme.colorScheme.coolGray50,
            textAlign = TextAlign.Center,
        )
        Text(
            text = stringResource(R.string.select_date),
            modifier =
                Modifier
                    .weight(6f)
                    .padding(vertical = 11.dp),
            style = Yes24TicketTheme.typography.headExtraBold17,
            color = Yes24TicketTheme.colorScheme.white,
            textAlign = TextAlign.Center,
        )
        Icon(
            modifier =
                Modifier.padding(end = 10.dp).noRippleClickable {
                    onCloseIconClicked()
                },
            imageVector = ImageVector.vectorResource(R.drawable.ic_reservation_close_24),
            contentDescription = "Close",
            tint = Yes24TicketTheme.colorScheme.gray250,
        )
    }
}

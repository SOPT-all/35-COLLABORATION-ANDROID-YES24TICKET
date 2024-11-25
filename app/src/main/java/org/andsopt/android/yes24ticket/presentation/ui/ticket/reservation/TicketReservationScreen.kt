package org.andsopt.android.yes24ticket.presentation.ui.ticket.reservation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.andsopt.android.yes24ticket.R
import org.andsopt.android.yes24ticket.presentation.ui.component.Yes24TopAppBar
import org.andsopt.android.yes24ticket.presentation.ui.ticket.reservation.viewmodel.TicketReservationViewModel
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme

@Composable
fun TicketReservationScreen(
    modifier: Modifier = Modifier,
    viewModel: TicketReservationViewModel = hiltViewModel()
) {

    val dayOfWeeks = viewModel.dayOfWeeks
    val days by viewModel.days.collectAsStateWithLifecycle()
    val selectableDays by viewModel.selectableDays.collectAsStateWithLifecycle()
    val selectedDay by viewModel.selectedDay.collectAsStateWithLifecycle()

    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        Yes24TopAppBar()
        ReservationTitleRow()
        
        CalendarView(
            dayOfWeeks = dayOfWeeks,
            selectableDays = selectableDays,
            selectedDay = selectedDay,
            days = days,
            onDaySelected = viewModel::onDaySelected,
            modifier = Modifier
                .padding(top = 10.dp)
                .padding(horizontal = 56.dp)
        )
    }
}

@Composable
fun ReservationTitleRow(
    modifier: Modifier = Modifier
) {
    val triWidth = with(LocalDensity.current) {
        12.dp.toPx()
    }
    val reserveBackgroundColor = Yes24TicketTheme.colorScheme.coolGray300

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .background(Yes24TicketTheme.colorScheme.coolGray100),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "예매하기",
            modifier = Modifier
                .weight(4.5f)
                .fillMaxHeight()
                .clipToBounds()
                .drawBehind {
                    drawRect(
                        size = size.copy(
                            width = size.width - triWidth + 1
                        ),
                        color = reserveBackgroundColor
                    )
                    val path = Path().apply {
                        moveTo(size.width - triWidth, 0f)
                        lineTo(size.width, size.height / 2)
                        lineTo(size.width - triWidth, size.height)
                        close()
                    }
                    drawPath(
                        path = path,
                        color = reserveBackgroundColor,
                    )

                    val borderPath = Path().apply {
                        moveTo(size.width - triWidth, 0f)
                        lineTo(size.width - 3, size.height / 2)
                        lineTo(size.width - triWidth, size.height)
                    }
                    drawPath(
                        path = borderPath,
                        color = Color.Black,
                        style = Stroke(width = 2.dp.toPx()),
                    )
                }.padding(vertical = 11.dp),
            style = Yes24TicketTheme.typography.titleBold15,
            color = Yes24TicketTheme.colorScheme.coolGray50,
            textAlign = TextAlign.Center
        )
        Text(
            text = "날짜/시간 선택",
            modifier = Modifier
                .weight(6f)
                .padding(vertical = 11.dp),
            style = Yes24TicketTheme.typography.headExtraBold17,
            color = Yes24TicketTheme.colorScheme.white,
            textAlign = TextAlign.Center
        )
        Icon(
            modifier = Modifier.padding(end = 15.dp),
            imageVector = ImageVector.vectorResource(R.drawable.ic_reservation_close_24),
            contentDescription = "Close",
            tint = Yes24TicketTheme.colorScheme.gray250
        )
    }
}

@Composable
@Preview
private fun ReservationTitleRowPreview() {
    ReservationTitleRow()
}
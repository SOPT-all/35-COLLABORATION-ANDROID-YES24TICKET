package org.andsopt.android.yes24ticket.presentation.ui.ticket.reservation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import org.andsopt.android.yes24ticket.R
import org.andsopt.android.yes24ticket.domain.model.TimeSlotsDataEntity
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme

@Composable
fun SelectConcertTimeView(
    timeSlots: TimeSlotsDataEntity,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        HorizontalDivider(
            color = Yes24TicketTheme.colorScheme.gray100,
        )
        Box(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .background(Yes24TicketTheme.colorScheme.gray50),
            contentAlignment = Alignment.CenterStart,
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 11.dp, vertical = 6.dp),
                text = stringResource(R.string.select_time),
                style = Yes24TicketTheme.typography.titleBold13,
                color = Yes24TicketTheme.colorScheme.gray600,
            )
        }
        timeSlots.slots.fastForEach { timeSlot ->
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 13.dp)
                        .padding(top = 4.dp, bottom = 14.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = timeSlot.performanceTime,
                    style = Yes24TicketTheme.typography.bodyMedium24,
                    color = Yes24TicketTheme.colorScheme.red100,
                )

                Spacer(modifier = Modifier.weight(1f))

                SelectTimeButton(
                    Modifier
                        .clip(shape = RoundedCornerShape(4.dp))
                        .background(Yes24TicketTheme.colorScheme.red100)
                        .clickable { },
                )
            }

            Column(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 5.dp)
                        .background(
                            color = Yes24TicketTheme.colorScheme.gray50,
                            shape = RoundedCornerShape(4.dp),
                        ),
            ) {
                Spacer(modifier = Modifier.height(15.dp))
                for (it in 0..<timeSlot.remainingSeats.size step 2) {
                    Row(
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(38.dp),
                    ) {
                        SeatItem(
                            remainingSeat = timeSlot.remainingSeats[it],
                            modifier =
                                Modifier
                                    .weight(1f),
                        )
                        if (it != timeSlot.remainingSeats.lastIndex) {
                            SeatItem(
                                remainingSeat = timeSlot.remainingSeats[it + 1],
                                modifier =
                                    Modifier
                                        .weight(1f),
                            )
                        } else {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                    if (it != timeSlot.remainingSeats.lastIndex) {
                        Spacer(modifier = Modifier.height(11.dp))
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}

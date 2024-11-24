package org.andsopt.android.yes24ticket.presentation.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme

@Composable
fun BannerPageIndicator(
    totalPage: Int,
    currentPage: Int,
    modifier: Modifier,
) {
    Box(
        modifier =
            modifier
                .clip(RoundedCornerShape(32.dp))
                .background(color = Yes24TicketTheme.colorScheme.whiteDim)
                .padding(horizontal = 8.dp, vertical = 4.dp),
    ) {
        Text(
            text = "$currentPage/$totalPage",
            style = Yes24TicketTheme.typography.captionBold10,
            color = Yes24TicketTheme.colorScheme.white,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
        )
    }
}

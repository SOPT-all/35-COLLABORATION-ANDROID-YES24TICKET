package org.andsopt.android.yes24ticket.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.andsopt.android.yes24ticket.R
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme

@Composable
fun ScrollToTopFloatingButton(
    onClick: () -> Unit,
    sizeDp : Dp = 30.dp,
    modifier: Modifier = Modifier
) {
    Column (modifier.fillMaxSize().background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = modifier
                .size(sizeDp)
                .clip(RoundedCornerShape(2.dp))
                .background(color = Yes24TicketTheme.colorScheme.red100)
                .shadow(
                    elevation = 4.dp,
                    shape = RoundedCornerShape(2.dp),
                    ambientColor = Color.Black.copy(alpha = 0.25f),
                    spotColor = Color.Black.copy(alpha = 0.25f)
                )
                .padding(horizontal = 2.dp, vertical = 1.dp)
                .clickable {
                    onClick()
                },
            contentAlignment = Alignment.BottomCenter

        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_up_white_12),
                contentDescription = "ic_arrow_up_white",
                modifier = modifier.padding(bottom = 13.5.dp),
                tint = Color.Unspecified
            )
            Text(
                text = stringResource(R.string.floating_action_button_top),
                style = Yes24TicketTheme.typography.captionRegular10,
                color = Yes24TicketTheme.colorScheme.white,
                modifier = modifier.padding(bottom = 4.5.dp)
            )
        }
    }
}


@Preview
@Composable
private fun FABPreview() {
    ScrollToTopFloatingButton({})
}
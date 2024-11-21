package org.andsopt.android.yes24ticket.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.andsopt.android.yes24ticket.R
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme

@Composable
fun Yes24TopAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Yes24TicketTheme.colorScheme.black)
                .padding(vertical = 5.dp, horizontal = 14.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.img_logo_yes24_84_37),
            contentDescription = stringResource(R.string.top_app_bar_logo_description),
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_bnv_search_selected_24),
            contentDescription = stringResource(R.string.top_app_bar_search_icon_description),
            tint = Color.Unspecified,
        )
    }
}

@Preview
@Composable
private fun TopAppBarPreview() {
    Yes24TopAppBar()
}

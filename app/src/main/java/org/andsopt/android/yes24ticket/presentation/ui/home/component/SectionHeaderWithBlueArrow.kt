package org.andsopt.android.yes24ticket.presentation.ui.home.component

import androidx.annotation.StringRes
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import org.andsopt.android.yes24ticket.R

@Composable
fun SectionHeaderWithBlueArrow(
    @StringRes text: Int,
    style: TextStyle,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.padding(start = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = stringResource(text),
            style = style,
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_right_blue_16),
            contentDescription = stringResource(R.string.home_arrow_blue_icon_decription),
            tint = Color.Unspecified,
            modifier = Modifier.padding(top = 1.dp),
        )
    }
}

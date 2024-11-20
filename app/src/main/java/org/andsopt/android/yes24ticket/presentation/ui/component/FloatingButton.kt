package org.andsopt.android.yes24ticket.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.andsopt.android.yes24ticket.R

@Composable
fun ScrollToTopFloatingButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(30.dp)
            .clip(RoundedCornerShape(2.dp))
            .background(Color.Red)
           ,
        contentAlignment = Alignment.BottomCenter

    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_up_white_12),
            contentDescription = "ic_arrow_up_white",
            modifier = modifier.padding(bottom = 13.5.dp),
            tint = Color.Unspecified
        )
        Text(
            text = "TOP",
            fontSize = 11.sp,
            modifier = modifier.padding(bottom = 4.5.dp)
        )
    }
}

@Preview
@Composable
private fun FABPreview() {
    ScrollToTopFloatingButton({})
}
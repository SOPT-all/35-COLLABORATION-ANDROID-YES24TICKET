package org.andsopt.android.yes24ticket.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
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
            .graphicsLayer {
                shadowElevation = 4.dp.toPx() // 블러 반경에 해당
                clip = true
            }
            .background(Color.Red)
            .padding(horizontal = 2.dp, vertical = 1.dp)
            .clickable {
                onClick()
            }
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
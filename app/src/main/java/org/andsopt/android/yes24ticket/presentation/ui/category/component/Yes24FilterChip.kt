package org.andsopt.android.yes24ticket.presentation.ui.category.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme
import org.andsopt.android.yes24ticket.util.compose.noRippleClickable

@Composable
fun Yes24FilterChip(
    chipTitle: String,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    onSelectedChange: (Boolean) -> Unit = {},
) {
    Text(
        text = chipTitle,
        modifier =
            modifier
                .border(
                    width = 1.dp,
                    color = if (!isSelected) Yes24TicketTheme.colorScheme.gray150 else Yes24TicketTheme.colorScheme.red100,
                    shape = RoundedCornerShape(4.dp),
                )
                .background(
                    color = if (!isSelected) Yes24TicketTheme.colorScheme.white else Yes24TicketTheme.colorScheme.red50,
                )
                .padding(vertical = 5.dp)
                .noRippleClickable { onSelectedChange(isSelected) },
        color = if (!isSelected) Yes24TicketTheme.colorScheme.gray300 else Yes24TicketTheme.colorScheme.red100,
        textAlign = TextAlign.Center,
        style = Yes24TicketTheme.typography.buttonBold13,
    )
}

@Preview
@Composable
private fun Yes24FilterChipPreview() {
    Yes24FilterChip(chipTitle = "인기순")
}

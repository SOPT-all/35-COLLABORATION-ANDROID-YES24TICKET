package org.andsopt.android.yes24ticket.presentation.ui.category.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.andsopt.android.yes24ticket.R
import org.andsopt.android.yes24ticket.presentation.type.FilterType
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme
import org.andsopt.android.yes24ticket.util.compose.noRippleClickable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectFilterBottomSheet(
    isBottomSheetVisible: Boolean,
    modifier: Modifier = Modifier,
    bottomSheetTitleText: String = stringResource(R.string.category_detail_filter_order),
    selectedFilter: FilterType? = null,
    onSelectedFilterChanged: (FilterType) -> Unit = {},
    onCloseButtonClick: (FilterType?) -> Unit = {},
    onDismissRequest: () -> Unit = {},
) {
    if (isBottomSheetVisible) {
        BasicModalBottomSheet(
            modifier =
                modifier
                    .padding(start = 13.dp, end = 13.dp, top = 16.dp, bottom = 38.dp),
            onDismissRequest = onDismissRequest,
            sheetState =
                rememberModalBottomSheetState(
                    confirmValueChange = { newState ->
                        !(newState == SheetValue.Hidden && isBottomSheetVisible)
                    },
                ),
        ) {
            Column {
                Row(
                    modifier =
                        Modifier
                            .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = bottomSheetTitleText,
                        style = Yes24TicketTheme.typography.titleBold15,
                        color = Yes24TicketTheme.colorScheme.gray900,
                    )

                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_reservation_close_24),
                        contentDescription = stringResource(R.string.category_detail_filter_close_description),
                        modifier =
                            Modifier
                                .noRippleClickable { onCloseButtonClick(selectedFilter) },
                    )
                }

                Spacer(modifier = Modifier.height(25.dp))

                Row {
                    FilterType.entries.forEachIndexed { index, filterType ->
                        val isSelected = selectedFilter == filterType

                        Yes24FilterChip(
                            chipTitle = stringResource(filterType.filter),
                            modifier = Modifier.weight(1f),
                            isSelected = isSelected,
                            onSelectedChange = {
                                if (index == ZERO) onSelectedFilterChanged(filterType)
                            },
                        )

                        if (index != FilterType.entries.size - 1) {
                            Spacer(modifier = Modifier.width(12.dp))
                        }
                    }
                }
            }
        }
    }
}

private const val ZERO = 0

@Preview
@Composable
private fun SelectFilterBottomSheetPreview() {
    var isBottomSheetVisible by rememberSaveable { mutableStateOf(true) }
    var selectedFilter by rememberSaveable { mutableStateOf<FilterType?>(null) }

    SelectFilterBottomSheet(
        isBottomSheetVisible = isBottomSheetVisible,
        selectedFilter = selectedFilter,
        onSelectedFilterChanged = { newSelectedFilter ->
            selectedFilter = newSelectedFilter
        },
        onDismissRequest = { isBottomSheetVisible = !isBottomSheetVisible },
    )
}

package org.andsopt.android.yes24ticket.presentation.ui.navigator.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.andsopt.android.yes24ticket.presentation.type.BottomNavigationType
import org.andsopt.android.yes24ticket.ui.theme.YES24TICKETTheme
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme
import org.andsopt.android.yes24ticket.util.compose.noRippleClickable

@Composable
fun BottomNavigationBar(
    navigationBarItems: List<BottomNavigationType>,
    currentNavigationBarItem: BottomNavigationType?,
    onNavigationBarItemSelected: (BottomNavigationType) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        navigationBarItems.forEach { navItem ->
            BottomNavigationItem(
                selected = currentNavigationBarItem == navItem,
                bottomNavType = navItem,
                onNavigationBarItemSelected = onNavigationBarItemSelected,
                icon = navItem.icon,
                label = navItem.description,
            )
        }
    }
}

@Composable
private fun BottomNavigationItem(
    selected: Boolean,
    bottomNavType: BottomNavigationType,
    onNavigationBarItemSelected: (BottomNavigationType) -> Unit,
    @DrawableRes icon: Int,
    @StringRes label: Int,
    modifier: Modifier = Modifier,
    spacing: Dp = 4.dp,
) {
    Column(
        modifier =
            modifier.noRippleClickable {
                onNavigationBarItemSelected(bottomNavType)
            },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = stringResource(label),
            tint =
                if (selected) {
                    Yes24TicketTheme.colorScheme.white
                } else {
                    Yes24TicketTheme.colorScheme.gray300
                },
        )
        Spacer(modifier = Modifier.height(spacing))
        Text(
            text = stringResource(label),
            style = Yes24TicketTheme.typography.captionRegular10,
            color =
                if (selected) {
                    Yes24TicketTheme.colorScheme.white
                } else {
                    Yes24TicketTheme.colorScheme.gray300
                },
        )
    }
}

@Preview
@Composable
private fun MainBottomBarPreview() {
    YES24TICKETTheme {
        BottomNavigationBar(
            modifier = Modifier.background(Yes24TicketTheme.colorScheme.black).padding(top = 5.dp, bottom = 10.dp),
            navigationBarItems = BottomNavigationType.entries.toList(),
            currentNavigationBarItem = BottomNavigationType.HOME,
            onNavigationBarItemSelected = {},
        )
    }
}

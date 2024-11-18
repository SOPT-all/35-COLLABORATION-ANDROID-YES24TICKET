package org.andsopt.android.yes24ticket.presentation.ui.navigator.component

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import org.andsopt.android.yes24ticket.presentation.type.BottomNavigationType
import org.andsopt.android.yes24ticket.ui.theme.YES24TICKETTheme

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    isVisible: Boolean,
    navigationBarItems: List<BottomNavigationType>,
    currentNavigationBarItem: BottomNavigationType?,
    onNavigationBarItemSelected: (BottomNavigationType) -> Unit,
) {
    AnimatedVisibility(visible = isVisible) {
        NavigationBar {
            navigationBarItems.forEach { mainNavigationBarItemType ->
                NavigationBarItem(
                    selected = currentNavigationBarItem == mainNavigationBarItemType,
                    onClick = { onNavigationBarItemSelected(mainNavigationBarItemType) },
                    icon = {
                        Icon(
                            painter = painterResource(id = mainNavigationBarItemType.icon),
                            contentDescription = context.getString(mainNavigationBarItemType.description),
                        )
                    },
                    label = { Text(text = stringResource(mainNavigationBarItemType.description)) },
                )
            }
        }
    }
}

@Preview
@Composable
private fun MainBottomBarPreview() {
    YES24TICKETTheme {
        BottomNavigationBar(
            isVisible = true,
            navigationBarItems = BottomNavigationType.entries.toList(),
            currentNavigationBarItem = BottomNavigationType.DUMMY,
            onNavigationBarItemSelected = {},
        )
    }
}

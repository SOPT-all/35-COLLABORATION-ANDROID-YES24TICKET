package org.andsopt.android.yes24ticket.presentation.ui.navigator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.andsopt.android.yes24ticket.presentation.type.BottomNavigationType
import org.andsopt.android.yes24ticket.presentation.ui.navigator.component.BottomNavigationBar
import org.andsopt.android.yes24ticket.ui.theme.YES24TICKETTheme
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme

@Composable
fun MainScreen(
    navigator: MainNavigator = rememberMainNavigator(),
) {
    MainScreenContent(
        navigator = navigator,
    )
}

@Composable
private fun MainScreenContent(
    modifier: Modifier = Modifier,
    navigator: MainNavigator,
) {
    Scaffold(
        modifier = modifier.padding(WindowInsets.navigationBars.asPaddingValues()),
        content = { padding ->
            MainNavHost(
                navigator = navigator,
                padding = padding,
            )
        },
        bottomBar = {
            if (navigator.showBottomBar()) {
                BottomNavigationBar(
                    modifier = Modifier.background(Yes24TicketTheme.colorScheme.black).padding(top = 5.dp, bottom = 10.dp),
                    navigationBarItems = BottomNavigationType.entries.toList(),
                    currentNavigationBarItem = navigator.currentMainNavigationBarItem,
                    onNavigationBarItemSelected = { navigator.navigateMainNavigation(it) },
                )
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    YES24TICKETTheme {
        MainScreen()
    }
}

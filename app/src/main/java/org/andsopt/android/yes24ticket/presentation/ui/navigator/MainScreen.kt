package org.andsopt.android.yes24ticket.presentation.ui.navigator

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.andsopt.android.yes24ticket.presentation.type.BottomNavigationType
import org.andsopt.android.yes24ticket.presentation.ui.navigator.component.BottomNavigationBar
import org.andsopt.android.yes24ticket.ui.theme.YES24TICKETTheme

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
        modifier = modifier,
        content = { padding ->
            MainNavHost(
                navigator = navigator,
                padding = padding,
            )
        },
        bottomBar = {
            BottomNavigationBar(
                isVisible = navigator.showBottomBar(),
                navigationBarItems = BottomNavigationType.entries.toList(),
                currentNavigationBarItem = navigator.currentMainNavigationBarItem,
                onNavigationBarItemSelected = { navigator.navigateMainNavigation(it) },
            )
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

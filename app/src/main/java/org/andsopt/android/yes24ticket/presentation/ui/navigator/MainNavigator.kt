package org.andsopt.android.yes24ticket.presentation.ui.navigator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import org.andsopt.android.yes24ticket.presentation.model.BottomNavigationRoute
import org.andsopt.android.yes24ticket.presentation.model.Route
import org.andsopt.android.yes24ticket.presentation.type.BottomNavigationType
import org.andsopt.android.yes24ticket.presentation.ui.dummy.navigationDummy

class MainNavigator(
    val navHostController: NavHostController
) {
    private val currentDestination: NavDestination?
        @Composable get() = navHostController.currentBackStackEntryAsState().value?.destination

    val startDestination = BottomNavigationType.DUMMY.route

    val currentMainNavigationBarItem: BottomNavigationType?
        @Composable get() = BottomNavigationType.find { mainBottomNavigationRoute ->
            currentDestination?.route == mainBottomNavigationRoute::class.simpleName
        }

    fun navigateMainNavigation(bottomNavigationType: BottomNavigationType) {
        navOptions {
            popUpTo(navHostController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }.let { navOptions ->
            when (bottomNavigationType) {
                BottomNavigationType.DUMMY -> navHostController.navigationDummy(navOptions)
            }
        }
    }

    private fun popBackStack() {
        navHostController.popBackStack()
    }

    fun popBackStackIfNotHome() {
        if (!isSameCurrentDestination<BottomNavigationRoute.Dummy>()) {
            popBackStack()
        }
    }

    private inline fun <reified T : Route> isSameCurrentDestination(): Boolean =
        navHostController.currentDestination?.route == T::class.simpleName

    @Composable
    fun showBottomBar(): Boolean = BottomNavigationType.contains {
        currentDestination?.route == it::class.simpleName
    }
}

@Composable
fun rememberMainNavigator(
    navHostController: NavHostController = rememberNavController()
): MainNavigator = remember(navHostController) {
    MainNavigator(navHostController = navHostController)
}
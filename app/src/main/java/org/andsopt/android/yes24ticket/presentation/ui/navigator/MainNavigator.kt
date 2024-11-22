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
import org.andsopt.android.yes24ticket.presentation.ui.home.navigationHome

class MainNavigator(
    val navHostController: NavHostController,
) {
    private val currentDestination: NavDestination?
        @Composable get() = navHostController.currentBackStackEntryAsState().value?.destination

    val startDestination = BottomNavigationType.HOME.route

    val currentMainNavigationBarItem: BottomNavigationType?
        @Composable get() =
            BottomNavigationType.find { mainBottomNavigationRoute ->
                currentDestination?.route == mainBottomNavigationRoute::class.qualifiedName
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
                BottomNavigationType.HOME -> navHostController.navigationHome(navOptions)
                else -> Unit
            }
        }
    }

    private fun popBackStack() {
        navHostController.popBackStack()
    }

    fun popBackStackIfNotHome() {
        if (!isSameCurrentDestination<BottomNavigationRoute.Home>()) {
            popBackStack()
        }
    }

    private inline fun <reified T : Route> isSameCurrentDestination(): Boolean =
        navHostController.currentDestination?.route == T::class.qualifiedName

    @Composable
    fun showBottomBar(): Boolean =
        BottomNavigationType.any {
            currentDestination?.route == it::class.qualifiedName
        }
}

@Composable
fun rememberMainNavigator(
    navHostController: NavHostController = rememberNavController(),
): MainNavigator =
    remember(navHostController) {
        MainNavigator(navHostController = navHostController)
    }

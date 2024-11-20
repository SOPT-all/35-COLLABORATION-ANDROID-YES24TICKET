package org.andsopt.android.yes24ticket.presentation.ui.dummy

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.andsopt.android.yes24ticket.presentation.model.BottomNavigationRoute
import org.andsopt.android.yes24ticket.presentation.ui.home.HomeScreen

fun NavController.navigationHome(navOptions: NavOptions) {
    navigate(
        route = BottomNavigationRoute.Home,
        navOptions = navOptions,
    )
}

fun NavGraphBuilder.homeNavGraph() {
    composable<BottomNavigationRoute.Home> {
        HomeScreen()
    }
}

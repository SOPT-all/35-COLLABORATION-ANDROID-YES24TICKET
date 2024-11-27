package org.andsopt.android.yes24ticket.presentation.ui.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.andsopt.android.yes24ticket.presentation.model.BottomNavigationRoute
import org.andsopt.android.yes24ticket.presentation.ui.category.CategoryDetailRoute
import org.andsopt.android.yes24ticket.presentation.ui.home.HomeRoute

fun NavController.navigationHome(navOptions: NavOptions) {
    navigate(
        route = BottomNavigationRoute.Home,
        navOptions = navOptions,
    )
}

fun NavGraphBuilder.homeNavGraph(
    navigateToCategoryDetail: () -> Unit,
) {
    composable<BottomNavigationRoute.Home> {
        /*HomeRoute(
            navigateToCategoryDetail = navigateToCategoryDetail,
        )*/
        CategoryDetailRoute(
            moveToBackStack = navigateToCategoryDetail
        )
    }
}

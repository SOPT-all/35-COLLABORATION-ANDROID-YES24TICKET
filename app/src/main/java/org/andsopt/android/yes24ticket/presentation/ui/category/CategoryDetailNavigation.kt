package org.andsopt.android.yes24ticket.presentation.ui.category

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavController.navigationCategoryDetail() {
    navigate(
        route = CategoryDetailRoute.ROUTE,
    )
}

fun NavGraphBuilder.categoryDetailNavGraph(
    moveToBackStack: () -> Unit,
) {
    composable(route = CategoryDetailRoute.ROUTE) {
        CategoryDetailRoute(
            moveToBackStack = moveToBackStack,
        )
    }
}

object CategoryDetailRoute {
    const val ROUTE = "categoryDetail"
}

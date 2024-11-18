package org.andsopt.android.yes24ticket.presentation.ui.dummy

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.andsopt.android.yes24ticket.presentation.model.BottomNavigationRoute

fun NavController.navigationDummy(navOptions: NavOptions) {
    navigate(
        route = BottomNavigationRoute.Dummy::class.simpleName.orEmpty(),
        navOptions = navOptions,
    )
}

fun NavGraphBuilder.dummyNavGraph(
    padding: PaddingValues,
) {
    composable(route = BottomNavigationRoute.Dummy::class.simpleName.orEmpty()) {
        DummyRoute(paddingValues = padding)
    }
}

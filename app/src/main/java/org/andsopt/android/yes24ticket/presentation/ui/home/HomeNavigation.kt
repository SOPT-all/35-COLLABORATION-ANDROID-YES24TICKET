package org.andsopt.android.yes24ticket.presentation.ui.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.andsopt.android.yes24ticket.presentation.model.BottomNavigationRoute

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
        /* TODO
            승범오빠! HomeRoute를 호출하는 것으로 변경해 주세요! DummyRoute 참고하시면 됨!
            서버통신을 통해 얻은 데이터만 Screen에 인자로 넘겨주는 흐름 */
        HomeScreen(
            navigateToCategoryDetail = navigateToCategoryDetail,
        )
    }
}

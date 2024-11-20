package org.andsopt.android.yes24ticket.presentation.type

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import org.andsopt.android.yes24ticket.R
import org.andsopt.android.yes24ticket.presentation.model.BottomNavigationRoute
import org.andsopt.android.yes24ticket.presentation.model.Route

enum class BottomNavigationType(
    @DrawableRes val icon: Int,
    @StringRes val description: Int,
    val route: BottomNavigationRoute,
) {
    HOME(
        icon = R.drawable.ic_bnv_home_selected_24,
        description = R.string.bottom_navigation_home,
        route = BottomNavigationRoute.Home,
    ),
    CATEGORY(
        icon = R.drawable.ic_bnv_category_selected_24,
        description = R.string.bottom_navigation_category,
        route = BottomNavigationRoute.Category,
    ),
    SEARCH(
        icon = R.drawable.ic_bnv_search_selected_24,
        description = R.string.bottom_navigation_search,
        route = BottomNavigationRoute.Search,
    ),
    MY_PAGE(
        icon = R.drawable.ic_bnv_my_selected_24,
        description = R.string.bottom_navigation_my,
        route = BottomNavigationRoute.MyPage,
    ),
    ;

    companion object {
        @Composable
        fun find(predicate: @Composable (BottomNavigationRoute) -> Boolean): BottomNavigationType? {
            return entries.find { predicate(it.route) }
        }

        @Composable
        fun contains(predicate: @Composable (Route) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}

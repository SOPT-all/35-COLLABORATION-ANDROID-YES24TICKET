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
    DUMMY(
        icon = R.drawable.ic_launcher_foreground,
        description = R.string.app_name,
        route = BottomNavigationRoute.Dummy,
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

package org.andsopt.android.yes24ticket.presentation.model

sealed interface Route

sealed interface BottomNavigationRoute : Route {
    data object Dummy : BottomNavigationRoute
}

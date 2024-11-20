package org.andsopt.android.yes24ticket.presentation.model

import kotlinx.serialization.Serializable

@Serializable
sealed interface Route

@Serializable
sealed interface BottomNavigationRoute : Route {
    @Serializable
    data object Dummy : BottomNavigationRoute
}

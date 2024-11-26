package org.andsopt.android.yes24ticket.presentation.ui.ticket.detail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.andsopt.android.yes24ticket.presentation.ui.ticket.detail.TicketDetailRoute

fun NavController.navigationTicketDetail(navOptions: NavOptions) {
    navigate(
        route = TicketDetailRoute.TICKET_DETAIL_ROUTE,
        navOptions = navOptions,
    )
}

fun NavGraphBuilder.ticketDetailNavGraph() {
    composable(route = TicketDetailRoute.TICKET_DETAIL_ROUTE) {
        TicketDetailRoute()
    }
}

object TicketDetailRoute {
    const val TICKET_DETAIL_ROUTE = "ticketDetail"
}
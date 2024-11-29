package org.andsopt.android.yes24ticket.presentation.ui.navigator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import org.andsopt.android.yes24ticket.presentation.ui.category.navigation.categoryDetailNavGraph
import org.andsopt.android.yes24ticket.presentation.ui.category.navigation.navigationCategoryDetail
import org.andsopt.android.yes24ticket.presentation.ui.home.navigation.homeNavGraph
import org.andsopt.android.yes24ticket.presentation.ui.ticket.detail.navigation.navigationTicketDetail
import org.andsopt.android.yes24ticket.presentation.ui.ticket.detail.navigation.ticketDetailNavGraph
import org.andsopt.android.yes24ticket.presentation.ui.ticket.reservation.navigation.navigationTicketReservation
import org.andsopt.android.yes24ticket.presentation.ui.ticket.reservation.navigation.ticketReservationNavGraph

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navigator: MainNavigator,
    padding: PaddingValues,
) {
    Box(
        modifier =
            modifier
                .fillMaxSize()
                .padding(padding)
                .background(MaterialTheme.colorScheme.surfaceDim),
    ) {
        NavHost(
            navController = navigator.navHostController,
            startDestination = navigator.startDestination,
        ) {
            homeNavGraph(
                navigateToCategoryDetail = {
                    navigator.navHostController.navigationCategoryDetail()
                },
            )
            categoryDetailNavGraph(
                navigateToTicketDetail = {
                    navigator.navHostController.navigationTicketDetail(it)
                },
            )
            ticketDetailNavGraph(
                navigationTicketReservation = { ticketId, title, place ->
                    navigator.navHostController.navigationTicketReservation(
                        ticketId = ticketId,
                        title = title,
                        place = place
                    )
                },
            )
            ticketReservationNavGraph()
        }
    }
}

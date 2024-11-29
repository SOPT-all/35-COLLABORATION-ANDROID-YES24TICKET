package org.andsopt.android.yes24ticket.presentation.ui.category.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.andsopt.android.yes24ticket.presentation.ui.category.CategoryDetailRoute

fun NavController.navigationCategoryDetail() {
    navigate(
        route = CategoryDetailRoute,
    )
}

fun NavGraphBuilder.categoryDetailNavGraph(
    navigateToTicketDetail: (Long) -> Unit,
) {
    composable<CategoryDetailRoute> {
        CategoryDetailRoute(
            onNavigateToTicketDetail = navigateToTicketDetail,
        )
    }
}

@Serializable
object CategoryDetailRoute {
    const val TICKET_DETAIL_ROUTE = "ticketDetail"
}

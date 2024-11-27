package org.andsopt.android.yes24ticket.presentation.ui.home.state

import org.andsopt.android.yes24ticket.domain.model.AdBannerEntity
import org.andsopt.android.yes24ticket.domain.model.DummyEntity
import org.andsopt.android.yes24ticket.domain.model.DummyIdEntity
import org.andsopt.android.yes24ticket.domain.model.LiveTicketRankingEntity
import org.andsopt.android.yes24ticket.domain.model.MainBannerEntity
import org.andsopt.android.yes24ticket.domain.model.WhatsHotEntity
import org.andsopt.android.yes24ticket.presentation.ui.dummy.state.DummyYes24UiState

sealed interface HomeUiState {
    data class Success(
        val mainBannerItemList: MainBannerEntity,
        val ticketRankingItemList: LiveTicketRankingEntity,
        val adBannerItemList: AdBannerEntity,
        val whatsHotItemList: WhatsHotEntity
    ) : HomeUiState

    data object Loading : HomeUiState

    data class Error(val message: String?) : HomeUiState
}
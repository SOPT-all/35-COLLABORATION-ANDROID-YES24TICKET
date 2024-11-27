package org.andsopt.android.yes24ticket.presentation.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import org.andsopt.android.yes24ticket.domain.repository.HomeRepository
import org.andsopt.android.yes24ticket.presentation.ui.home.state.HomeUiState
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject
constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {
    val homeUiState: StateFlow<HomeUiState> =
        flow<HomeUiState> {
            val mainBannerList =
                viewModelScope.async {
                    homeRepository.fetchMainBannerList()
                }.await().getOrElse { throwable ->
                    Log.d("fetchMainBannerList", throwable.message.toString())
                    emit(HomeUiState.Error(throwable.message))
                    return@flow
                }

            val ticketRankingList =
                viewModelScope.async {
                    homeRepository.fetchTicketRankingList()
                }.await().getOrElse { throwable ->
                    Log.d("fetchMainBannerList", throwable.message.toString())

                    emit(HomeUiState.Error(throwable.message))
                    return@flow
                }
            val adBannerList =
                viewModelScope.async {
                    homeRepository.fetchAdBannerList()
                }.await().getOrElse { throwable ->
                    Log.d("fetchMainBannerList", throwable.message.toString())

                    emit(HomeUiState.Error(throwable.message))
                    return@flow
                }

            val whatsHotList =
                viewModelScope.async {
                    homeRepository.fetchWhatsHotList()
                }.await().getOrElse { throwable ->
                    Log.d("fetchMainBannerList", throwable.message.toString())

                    emit(HomeUiState.Error(throwable.message))
                    return@flow
                }


            emit(
                HomeUiState.Success(
                    mainBannerItemList = mainBannerList,
                    ticketRankingItemList = ticketRankingList,
                    adBannerItemList = adBannerList,
                    whatsHotItemList = whatsHotList
                )
            )
        }.catch { throwable ->
            emit(HomeUiState.Error(throwable.message))
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = HomeUiState.Loading
        )
}

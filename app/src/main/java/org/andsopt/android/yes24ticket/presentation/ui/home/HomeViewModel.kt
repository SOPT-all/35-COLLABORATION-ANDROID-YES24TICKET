package org.andsopt.android.yes24ticket.presentation.ui.home

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
        private val homeRepository: HomeRepository,
    ) : ViewModel() {
        val homeUiState: StateFlow<HomeUiState> =
            flow {
                val mainBannerList =
                    viewModelScope.async {
                        homeRepository.fetchMainBannerList()
                    }

                val ticketRankingList =
                    viewModelScope.async {
                        homeRepository.fetchTicketRankingList()
                    }
                val adBannerList =
                    viewModelScope.async {
                        homeRepository.fetchAdBannerList()
                    }

                val whatsHotList =
                    viewModelScope.async {
                        homeRepository.fetchWhatsHotList()
                    }
                emit(
                    HomeUiState.Success(
                        mainBannerItemList =
                            mainBannerList.await().getOrElse { throwable ->
                                emit(HomeUiState.Error(throwable.message))
                                return@flow
                            },
                        ticketRankingItemList =
                            ticketRankingList.await().getOrElse { throwable ->
                                emit(HomeUiState.Error(throwable.message))
                                return@flow
                            },
                        adBannerItemList =
                            adBannerList.await().getOrElse { throwable ->
                                emit(HomeUiState.Error(throwable.message))
                                return@flow
                            },
                        whatsHotItemList =
                            whatsHotList.await().getOrElse { throwable ->
                                emit(HomeUiState.Error(throwable.message))
                                return@flow
                            },
                    ),
                )
            }.catch { throwable ->
                emit(HomeUiState.Error(throwable.message))
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = HomeUiState.Loading,
            )
    }

package org.andsopt.android.yes24ticket.presentation.ui.dummy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import org.andsopt.android.yes24ticket.domain.model.DummyNameEntity
import org.andsopt.android.yes24ticket.domain.repository.DummyRepository
import org.andsopt.android.yes24ticket.presentation.ui.dummy.state.DummyYes24UiState
import javax.inject.Inject

@HiltViewModel
class DummyViewModel
    @Inject
    constructor(
        private val dummyRepository: DummyRepository,
    ) : ViewModel() {
        val dummyYes24UiState: StateFlow<DummyYes24UiState> =
            flow<DummyYes24UiState> {

                val dummyA =
                    viewModelScope.async {
                        dummyRepository.getDummyData(dummyNameEntity = DummyNameEntity(dummyName = "더미더미"))
                    }.await().getOrElse { throwable ->
                        emit(DummyYes24UiState.Error(throwable.message))
                        return@flow
                    }

                val dummyB =
                    viewModelScope.async {
                        dummyRepository.getDummyExampleData()
                    }.await().getOrElse { throwable ->
                        emit(DummyYes24UiState.Error(throwable.message))
                        return@flow
                    }

                emit(DummyYes24UiState.Success(dummyA, dummyB))
            }.catch { throwable ->
                emit(DummyYes24UiState.Error(throwable.message))
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = DummyYes24UiState.Loading,
            )
    }

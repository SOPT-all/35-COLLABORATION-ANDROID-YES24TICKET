package org.andsopt.android.yes24ticket.presentation.ui.dummy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.andsopt.android.yes24ticket.domain.model.DummyNameEntity
import org.andsopt.android.yes24ticket.domain.repository.DummyRepository
import org.andsopt.android.yes24ticket.presentation.ui.dummy.state.DummyUiState
import org.andsopt.android.yes24ticket.presentation.ui.dummy.state.DummyYes24UiState
import org.andsopt.android.yes24ticket.util.base.UiState
import org.andsopt.android.yes24ticket.util.view.LoadState
import javax.inject.Inject

@HiltViewModel
class DummyViewModel
@Inject
constructor(
    private val dummyRepository: DummyRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState>(DummyUiState())
    val uiState: StateFlow<UiState>
        get() = _uiState.asStateFlow()

    private val _dummyYes = MutableStateFlow(0)
    private val _dummy24 = MutableStateFlow("")

    val dummyYes24UiState: StateFlow<DummyYes24UiState> =
        combine(_dummyYes, _dummy24) { dummyYes, dummy24 ->
            DummyYes24UiState(dummyYes = dummyYes.toString(), dummy24 = dummy24.toInt())
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = DummyYes24UiState()
        )

    fun getDummyData() {
        viewModelScope.launch {
            val currentState = _uiState.value as DummyUiState
            _uiState.update { currentState.copy(loadState = LoadState.Loading) }

            dummyRepository.getDummyData(
                dummyNameEntity =
                    DummyNameEntity(
                        dummyName = "더미더미",
                    ),
            ).onSuccess { dummyIdEntity ->
                _uiState.update {
                    currentState.copy(
                        dummyString = dummyIdEntity.dummyId,
                        loadState = LoadState.Success,
                    )
                }
            }.onFailure {
                _uiState.update {
                    currentState.copy(
                        loadState = LoadState.Fail,
                    )
                }
            }
        }
    }

    fun getDummyExampleDate() {
        viewModelScope.launch {
            val currentState = _uiState.value as DummyUiState
            _uiState.update { currentState.copy(loadState = LoadState.Loading) }

            dummyRepository.getDummyExampleData().onSuccess { dummyEntity ->
                _uiState.update {
                    currentState.copy(
                        dummySecondString = dummyEntity.dummyA,
                        loadState = LoadState.Loading,
                    )
                }
            }.onFailure {
                _uiState.update {
                    currentState.copy(
                        loadState = LoadState.Fail,
                    )
                }
            }
        }
    }
}

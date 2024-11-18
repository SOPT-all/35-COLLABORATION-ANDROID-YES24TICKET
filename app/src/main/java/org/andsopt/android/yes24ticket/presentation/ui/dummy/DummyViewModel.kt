package org.andsopt.android.yes24ticket.presentation.ui.dummy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.andsopt.android.yes24ticket.domain.model.DummyNameEntity
import org.andsopt.android.yes24ticket.domain.repository.DummyRepository
import javax.inject.Inject

@HiltViewModel
class DummyViewModel @Inject constructor(
    private val dummyRepository: DummyRepository
) : ViewModel() {
    private val _dummyState = MutableStateFlow(DummyUiState())
    val dummyState: StateFlow<DummyUiState>
        get() = _dummyState.asStateFlow()

    fun getDummyData() {
        viewModelScope.launch {
            dummyRepository.getDummyData(
                dummyNameEntity = DummyNameEntity(
                    dummyName = "더미더미"
                )
            ).onSuccess { dummyIdEntity ->
                _dummyState.value = _dummyState.value.copy(
                    dummyState = dummyIdEntity.dummyId
                )
            }.onFailure {

            }
        }
    }
}
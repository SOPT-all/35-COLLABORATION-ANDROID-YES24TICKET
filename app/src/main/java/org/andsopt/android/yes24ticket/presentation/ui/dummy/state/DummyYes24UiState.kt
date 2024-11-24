package org.andsopt.android.yes24ticket.presentation.ui.dummy.state

import org.andsopt.android.yes24ticket.domain.model.DummyEntity
import org.andsopt.android.yes24ticket.domain.model.DummyIdEntity

sealed interface DummyYes24UiState {
    data class Success(val dummyA: DummyIdEntity, val dummyB: DummyEntity) : DummyYes24UiState
    data object Loading : DummyYes24UiState
    data class Error(val message: String?) : DummyYes24UiState
}
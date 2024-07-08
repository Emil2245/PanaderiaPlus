package com.app.panaderiaplus.ui.screen.pan_detalles

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.panaderiaplus.data.IPanRepository
import com.app.panaderiaplus.ui.screen.pan_detalles.exception.PanNotFoundException
import com.app.panaderiaplus.ui.screen.pan_detalles.mapper.PanDetallesMapper
import com.app.panaderiaplus.ui.screen.pan_detalles.model.PanDetalles
import com.app.panaderiaplus.ui.screen.pan_detalles.model.PanDetallesState
import com.app.panaderiaplus.ui.state.UiState
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class PanDetallesViewModel(
    private val repository: IPanRepository,
    private val mapper: PanDetallesMapper
) : ViewModel() {
    private val _uiState: MutableLiveData<UiState<PanDetallesState>> = MutableLiveData()
    val uiState: LiveData<UiState<PanDetallesState>>
        get() = _uiState

    fun cargarDetallesPan(panId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            repository.getPan(panId)
                .map { mapper.map(it) }
                .collect { pan ->
                    if (pan != null) {
                        _uiState.value = UiState.Success(PanDetallesState(pan))
                    } else {
                        _uiState.value = UiState.Error(PanNotFoundException())
                    }
                }
        }
    }

    fun changeFavouriteState(pan: PanDetalles) {
        viewModelScope.launch {
            repository.updateFavouriteState(pan.id, !pan.isFavourite)
                .collect { result ->
                    if (result) {
                        cargarDetallesPan(pan.id)
                    }
                }
        }
    }
}

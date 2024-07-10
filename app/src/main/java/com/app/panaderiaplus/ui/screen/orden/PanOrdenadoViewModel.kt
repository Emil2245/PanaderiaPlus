package com.app.panaderiaplus.ui.screen.orden

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.panaderiaplus.data.order.IPanOrdenadoRepository
import com.app.panaderiaplus.ui.screen.orden.model.PanOrdenadoState
import com.app.panaderiaplus.ui.state.UiState
import kotlinx.coroutines.launch
import java.math.BigDecimal

class PanOrdenadoViewModel(
    private val repository: IPanOrdenadoRepository
) : ViewModel() {
    private val _uiState: MutableLiveData<UiState<PanOrdenadoState>> = MutableLiveData()
    val uiState: LiveData<UiState<PanOrdenadoState>>
        get() = _uiState

    fun loadPanes() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            repository.listarPanes()
                .collect { panes ->
                    val totalCount = panes
                        .filter { it.count > 0 }
                        .map { it.count * it.price }
                        .sum()

                    _uiState.value = UiState.Success(
                        PanOrdenadoState(
                            listaPanes = panes,
                            totalPrice = BigDecimal(totalCount)
                        )
                    )
                }
        }
    }

    fun addPan(panId: Long) {
        viewModelScope.launch {
            repository.add(panId)
                .collect { isAdded ->
                    if (isAdded) {
                        loadPanes()
                    }
                }
        }
    }

    fun removePan(panId: Long) {
        viewModelScope.launch {
            repository.remove(panId)
                .collect { isRemoved ->
                    if (isRemoved) {
                        loadPanes()
                    }
                }
        }
    }
}


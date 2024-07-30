package com.app.panaderiaplus.ui.screen.panes_base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.panaderiaplus.data.IPanRepository
import com.app.panaderiaplus.ui.screen.panes_base.mapper.PanItemMapper
import com.app.panaderiaplus.ui.screen.panes_base.model.PanItem
import com.app.panaderiaplus.ui.screen.panes_base.model.PanState
import com.app.panaderiaplus.ui.screen.panes_base.model.DisplayingOptions
import com.app.panaderiaplus.ui.state.UiState
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class PanViewModel(
    private val repository: IPanRepository,
    private val mapper: PanItemMapper
) : ViewModel() {
    private var currentDisplayingOption = DisplayingOptions.LIST
    private var currentCategory = "todos" // Valor inicial por defecto

    private val _uiState: MutableLiveData<UiState<PanState>> = MutableLiveData()
    val uiState: LiveData<UiState<PanState>>
        get() = _uiState

    fun cargarPanes() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            repository.listarPanes()
                .map { panes ->
                    panes.map { mapper.map(it) }
                }
                .collect {
                    _uiState.value = UiState.Success(
                        PanState(
                            it,
                            currentDisplayingOption
                        )
                    )
                }
        }
    }

    fun changeDisplayingOption() {
        when (val state = _uiState.value) {
            is UiState.Success -> {
                currentDisplayingOption = if (currentDisplayingOption == DisplayingOptions.LIST) {
                    DisplayingOptions.CARDS
                } else {
                    DisplayingOptions.LIST
                }
                _uiState.value = UiState.Success(state.data.copy(displayingOption = currentDisplayingOption))
            }
            else -> cargarPanes()
        }
    }

    fun changeFavouriteState(pan: PanItem) {
        viewModelScope.launch {
            repository.updateFavouriteState(pan.id, !pan.isFavourite)
                .collect { result ->
                    if (result) {
                        cargarPanes()
                    }
                }
        }
    }

    fun filterProductsByCategory(category: String) {
        currentCategory = category
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            repository.listarPanes()
                .map { panes ->
                    panes.map { mapper.map(it) }
                }
                .collect { panes ->
                    val filteredPanes = panes.filter { pan ->
                        pan.category == currentCategory || currentCategory == "todos"
                    }
                    _uiState.value = UiState.Success(
                        PanState(
                            filteredPanes,
                            currentDisplayingOption
                        )
                    )
                }
        }
    }

}

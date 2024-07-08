package com.app.panaderiaplus.ui.screen.orden.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class PanOrdenadoUI(
    val id: Long,
    val name: String,
    @DrawableRes val imageRes: Int,
    val description: String,
    val price: Double,
    // TODO: should be immutable
    var count: MutableState<Int> = mutableStateOf(0)
)

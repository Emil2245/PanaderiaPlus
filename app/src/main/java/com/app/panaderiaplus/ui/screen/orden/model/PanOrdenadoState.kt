package com.app.panaderiaplus.ui.screen.orden.model

import com.app.panaderiaplus.data.order.PanOrdenado
import java.math.BigDecimal

data class PanOrdenadoState(
    val listaPanes: List<PanOrdenado>,
    val totalPrice: BigDecimal
)

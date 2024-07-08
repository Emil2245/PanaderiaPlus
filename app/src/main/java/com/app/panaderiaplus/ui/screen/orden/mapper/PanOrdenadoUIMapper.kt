package com.app.panaderiaplus.ui.screen.orden.mapper

import androidx.compose.runtime.mutableStateOf
import com.app.panaderiaplus.data.Pan
import com.app.panaderiaplus.ui.screen.orden.model.PanOrdenadoUI

class PanOrdenadoUIMapper {

    fun map(pan: Pan): PanOrdenadoUI {
        return PanOrdenadoUI(
            id = pan.id,
            name = pan.name,
            imageRes = pan.imageUrl,
            description = pan.orderDescription,
            price = pan.price,
            count = mutableStateOf(0)
        )
    }
}

package com.app.panaderiaplus.ui.screen.pan_detalles.mapper

import com.app.panaderiaplus.data.Pan
import com.app.panaderiaplus.ui.screen.pan_detalles.model.PanDetalles

class PanDetallesMapper {

    fun map(pan: Pan?): PanDetalles? {
        if (pan == null) {
            return null
        }

        return PanDetalles(
            id = pan.id,
            name = pan.name,
            imageUrl = pan.imageUrl,
            ingredients = pan.ingredients,
            description = pan.description,
            isFavourite = pan.isFavourite
        )
    }
}

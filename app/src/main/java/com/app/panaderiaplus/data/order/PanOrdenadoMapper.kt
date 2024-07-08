package com.app.panaderiaplus.data.order

import com.app.panaderiaplus.data.Pan

class PanOrdenadoMapper {

    fun map(pan: Pan, count: Int = 0): PanOrdenado {
        return PanOrdenado(
            id = pan.id,
            name = pan.name,
            imageUrl = pan.imageUrl,
            ingredients = pan.ingredients,
            price = pan.price,
            count = count
        )
    }

    fun map(pans: List<Pan>, count: Int = 0): List<PanOrdenado> {
        return pans.map { map(it, count) }
    }
}

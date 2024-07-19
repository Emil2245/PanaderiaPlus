package com.app.panaderiaplus.ui.screen.panes_base.mapper

import com.app.panaderiaplus.ui.screen.panes_base.model.PanItem
import com.app.panaderiaplus.data.Pan

class PanItemMapper {

    fun map(pan: Pan): PanItem {
        return PanItem(
            id = pan.id,
            name = pan.name,
            imageUrl = pan.imageUrl,
            ingredients = pan.ingredients,
            description = pan.description,
            isFavourite = pan.isFavourite,
            category = pan.category
        )
    }
}

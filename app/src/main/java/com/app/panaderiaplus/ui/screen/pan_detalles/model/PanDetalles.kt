package com.app.panaderiaplus.ui.screen.pan_detalles.model

data class PanDetalles(
    val id: Long,
    val name: String,
    val imageUrl: Int,
    val ingredients: String,
    val description: String,
    var isFavourite: Boolean
)

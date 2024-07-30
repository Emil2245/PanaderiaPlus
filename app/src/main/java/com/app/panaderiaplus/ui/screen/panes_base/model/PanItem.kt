package com.app.panaderiaplus.ui.screen.panes_base.model

data class PanItem(
    val id: Long,
    val name: String,
    val imageUrl: Int,
    val ingredients: String,
    val description: String,
    val isFavourite: Boolean,
    val category: String
)

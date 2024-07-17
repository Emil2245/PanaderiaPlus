package com.app.panaderiaplus.ui.screen.factura

import kotlinx.serialization.Serializable

@Serializable
data class Pedido(
    val nombre: String,
    val cedula: String,
    val direccion: String,
    val telefono: String,
    val tarjetaNumero: String,
    val panes: List<Pan>
)

@Serializable
data class Pan(
    val name: String,
    val count: Int,
    val price: Double
)

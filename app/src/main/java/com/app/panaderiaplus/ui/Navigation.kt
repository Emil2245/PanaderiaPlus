package com.app.panaderiaplus.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.panaderiaplus.R
import java.lang.IllegalArgumentException

enum class Screen {
    Panes,
    PanesDetallados,
    PanesOrdenados,
    Qr,
    Factura
}

fun Fragment.navigate(from: Screen, to: Screen, bundle: Bundle? = null) {
    val id = mapScreenToId(from, to)
    if (bundle == null) {
        findNavController().navigate(id)
    } else {
        findNavController().navigate(id, bundle)
    }
}

fun Fragment.navigateToPreviousScreen(from: Screen, to: Screen) {
    val id = mapScreenToId(from, to)
    findNavController().popBackStack(id, false)
}

private fun mapScreenToId(from: Screen, to: Screen): Int {
    if (to == from) {
        throw IllegalArgumentException("Cannot navigate from $from to $to")
    }
    return when (to) {
        Screen.Panes -> R.id.panFragment
        Screen.PanesDetallados -> R.id.panDetallesFragment
        Screen.PanesOrdenados -> R.id.panOrdenadoFragment
        Screen.Qr -> R.id.qrFragment
        Screen.Factura -> R.id.facturaFragment
    }
}

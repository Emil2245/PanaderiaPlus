package com.app.panaderiaplus.ui.screen.factura

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.app.panaderiaplus.R
import com.app.panaderiaplus.ui.screen.generatePDF
import com.app.panaderiaplus.ui.theme.PanaderiaPlusTheme

class FacturaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            id = R.id.facturaFragment
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            setContent {
                PanaderiaPlusTheme {
                    val qrData = arguments?.getString("qrData") ?: ""
                    val paymentMethod = arguments?.getString("paymentMethod") ?: "tarjeta"
                    FacturaScreen(
                        paymentMethod = paymentMethod,
                        onBackClick = { findNavController().popBackStack() },
                        onProceedToQR = { nombre, cedula, direccion, telefono, tarjetaNumero ->
                            val clienteInfo = "Nombre: $nombre, Cedula: $cedula, Direccion: $direccion, Telefono: $telefono"
                            val tarjetaInfo = if (paymentMethod == "tarjeta") "\nTarjeta: $tarjetaNumero" else ""
                            val fullQrData = "$qrData\n$clienteInfo$tarjetaInfo"
                            val bundle = Bundle().apply {
                                putString("qrData", fullQrData)
                                putString("clienteNombre", nombre)
                                putString("paymentMethod", paymentMethod)
                            }
                            findNavController().navigate(R.id.qrFragment, bundle)
                        },
                        onGeneratePDF = { nombre, cedula, direccion, telefono, tarjetaNumero, panes ->
                            val pdfPath = generatePDF(requireContext(), nombre, cedula, direccion, telefono, tarjetaNumero, panes)
                            val bundle = Bundle().apply {
                                putString("pdfPath", pdfPath)
                            }
                            findNavController().navigate(R.id.pdfViewerFragment, bundle)
                        }
                    )
                }
            }
        }
    }
}

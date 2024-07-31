package com.app.panaderiaplus.ui.screen.orden

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.panaderiaplus.R
import com.app.panaderiaplus.ui.Screen
import com.app.panaderiaplus.ui.navigate
import com.app.panaderiaplus.ui.navigateToPreviousScreen
import com.app.panaderiaplus.ui.state.UiState
import com.app.panaderiaplus.ui.theme.PanaderiaPlusTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

@ExperimentalAnimationApi
class PanOrdenadoFragment : Fragment() {
    private val viewModel: PanOrdenadoViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            id = R.id.panDetallesFragment
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )

            setContent {
                val context = LocalContext.current

                PanaderiaPlusTheme {
                    viewModel.uiState.observeAsState(initial = UiState.Loading).value.let { uiState ->
                        when (uiState) {
                            is UiState.Loading -> {
                                CargandoPanScreen()
                            }
                            is UiState.Success -> {
                                MostrarPanCorrectoScreen(
                                    panOrdenadoState = uiState.data,
                                    viewModel = viewModel,
                                    onBack = {
                                        this@PanOrdenadoFragment.navigateToPreviousScreen(
                                            Screen.PanesOrdenados,
                                            Screen.Panes
                                        )
                                    },
                                    onProceedToQR = {
                                        val filteredPanes = uiState.data.listaPanes.filter { it.count > 0 }
                                        if (filteredPanes.isEmpty()) {
                                            Toast.makeText(context, "Debe seleccionar al menos un elemento", Toast.LENGTH_SHORT).show()
                                        } else {
                                            val qrData = filteredPanes.joinToString(separator = "\n") {
                                                "{ item: ${it.name}, cantidad: ${it.count}, precio: ${it.price} },\n"
                                            }
                                            val bundle = Bundle().apply {
                                                putString("qrData", qrData)
                                                putSerializable("panes", ArrayList(filteredPanes))  // Pasar la lista de panes
                                                putString("paymentMethod", "tarjeta")
                                            }
                                            this@PanOrdenadoFragment.navigate(
                                                Screen.PanesOrdenados,
                                                Screen.Factura, // Navegamos a la pantalla de factura
                                                bundle
                                            )
                                        }
                                    },
                                    onProceedToCajaQR = {
                                        val filteredPanes = uiState.data.listaPanes.filter { it.count > 0 }
                                        if (filteredPanes.isEmpty()) {
                                            Toast.makeText(context, "Debe seleccionar al menos un elemento", Toast.LENGTH_SHORT).show()
                                        } else {
                                            val qrData = filteredPanes.joinToString(separator = "\n") {
                                                "{ item: ${it.name}, cantidad: ${it.count}, precio: ${it.price} },\n"
                                            }
                                            val bundle = Bundle().apply {
                                                putString("qrData", qrData)
                                                putSerializable("panes", ArrayList(filteredPanes))  // Pasar la lista de panes
                                                putString("paymentMethod", "caja")
                                            }
                                            this@PanOrdenadoFragment.navigate(
                                                Screen.PanesOrdenados,
                                                Screen.Factura, // Navegamos a la pantalla de factura
                                                bundle
                                            )
                                        }
                                    }
                                )
                            }
                            is UiState.Error -> {
                                // Implementar pantalla de error
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadPanes()
    }
}

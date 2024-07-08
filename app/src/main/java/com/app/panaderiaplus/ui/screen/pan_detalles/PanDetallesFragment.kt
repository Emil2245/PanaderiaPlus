package com.app.panaderiaplus.ui.screen.pan_detalles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.app.panaderiaplus.R
import com.app.panaderiaplus.ui.Screen
import com.app.panaderiaplus.ui.navigateToPreviousScreen
import com.app.panaderiaplus.ui.state.UiState
import com.app.panaderiaplus.ui.theme.PanaderiaPlusTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class PanDetallesFragment : Fragment() {
    private val viewModel: PanDetallesViewModel by viewModel()

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
                PanaderiaPlusTheme {
                    viewModel.uiState.observeAsState(initial = UiState.Loading).value.let { uiState ->
                        when (uiState) {
                            is UiState.Loading -> {
                                MostarPanDetallesCargandoScreen()
                            }
                            is UiState.Success -> {
                                MostrarPanDetallesCorrectoScreen(
                                    onBack = {
                                        this@PanDetallesFragment.navigateToPreviousScreen(
                                            Screen.PanesDetallados,
                                            Screen.Panes
                                        )
                                    },
                                    panDetalleState = uiState.data,
                                    viewModel = viewModel
                                )
                            }
                            is UiState.Error -> {
                                ShowErrorPanDetallesScreen()
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.cargarDetallesPan(arguments?.getLong("id") ?: -1)
    }
}

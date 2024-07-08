package com.app.panaderiaplus.ui.screen.panes_base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.ComposeView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.app.panaderiaplus.R
import com.app.panaderiaplus.ui.Screen
import com.app.panaderiaplus.ui.navigate
import com.app.panaderiaplus.ui.state.UiState
import com.app.panaderiaplus.ui.theme.PanaderiaPlusTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class PanFragment : Fragment() {
    private val viewModel: PanViewModel by viewModel()

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
                                MostrarPanCargandoScreen()
                            }
                            is UiState.Success -> {
                                MostrarPanesCorrectosScreen(
                                    panState = uiState.data,
                                    viewModel = viewModel,
                                    panOrdenadoMenuItem = {
                                        this@PanFragment.navigate(
                                            Screen.Panes,
                                            Screen.PanesOrdenados
                                        )
                                    },
                                    panSeleccionado = { pan ->
                                        this@PanFragment.navigate(
                                            Screen.Panes,
                                            Screen.PanesDetallados,
                                            bundleOf("id" to pan.id)
                                        )
                                    }
                                )
                            }
                            is UiState.Error -> {
                                MostrarErrorPanScreen()
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.cargarPanes()
    }
}

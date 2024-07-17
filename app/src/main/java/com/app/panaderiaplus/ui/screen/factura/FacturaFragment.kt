package com.app.panaderiaplus.ui.screen.factura

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.app.panaderiaplus.R
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
                    FacturaScreen(onBackClick = { findNavController().popBackStack() })
                }
            }
        }
    }
}

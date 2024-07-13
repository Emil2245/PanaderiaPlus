package com.app.panaderiaplus.ui.screen.qr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.compose.ui.platform.ComposeView
import com.app.panaderiaplus.R
import com.app.panaderiaplus.ui.theme.PanaderiaPlusTheme

class QrFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            id = R.id.qrFragment
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )

            val qrData = arguments?.getString("qrData") ?: ""

            setContent {
                PanaderiaPlusTheme {
                    QrScreen(qrData)
                }
            }
        }
    }
}

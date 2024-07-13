package com.app.panaderiaplus.ui.screen.qr;

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import com.app.panaderiaplus.ui.screen.orden.QRCodeEncoder

@Composable
fun QrScreen(qrData: String) {
    val bitmap = remember {
        QRCodeEncoder().encodeAsBitmap(qrData, 400, 400)
    }
    Column(
            modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
    ) {
        Text("QR Code", style = MaterialTheme.typography.titleMedium)
        Image(
                bitmap = bitmap.asImageBitmap(),
                contentDescription = null,
                modifier = Modifier.size(300.dp)
        )
    }
}
package com.app.panaderiaplus.ui.screen.orden

import android.graphics.Bitmap
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.common.BitMatrix

class QRCodeEncoder {
    fun encodeAsBitmap(data: String, width: Int, height: Int): Bitmap {
        val bitMatrix: BitMatrix = MultiFormatWriter().encode(
            data, BarcodeFormat.QR_CODE, width, height
        )
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
        for (x in 0 until width) {
            for (y in 0 until height) {
                bitmap.setPixel(x, y, if (bitMatrix[x, y]) android.graphics.Color.BLACK else android.graphics.Color.WHITE)
            }
        }
        return bitmap
    }
}

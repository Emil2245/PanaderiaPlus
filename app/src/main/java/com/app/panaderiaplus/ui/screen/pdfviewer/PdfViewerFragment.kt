package com.app.panaderiaplus.ui.screen.pdfviewer

import android.graphics.Bitmap
import android.graphics.pdf.PdfRenderer
import android.os.Bundle
import android.os.ParcelFileDescriptor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.app.panaderiaplus.R
import java.io.File
import java.io.IOException

class PdfViewerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pdf_viewer, container, false)
        val pdfImageView = view.findViewById<ImageView>(R.id.pdfImageView)

        val pdfPath = arguments?.getString("pdfPath") ?: ""
        val file = File(pdfPath)

        if (file.exists()) {
            try {
                val fileDescriptor = ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY)
                val pdfRenderer = PdfRenderer(fileDescriptor)
                val page = pdfRenderer.openPage(0)

                val bitmap = Bitmap.createBitmap(page.width, page.height, Bitmap.Config.ARGB_8888)
                page.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
                pdfImageView.setImageBitmap(bitmap)

                page.close()
                pdfRenderer.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        return view
    }
}

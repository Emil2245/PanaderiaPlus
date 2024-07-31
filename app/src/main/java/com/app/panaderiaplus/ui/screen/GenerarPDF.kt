package com.app.panaderiaplus.ui.screen

import android.content.Context
import android.os.Environment
import com.app.panaderiaplus.ui.screen.factura.Pan
import com.itextpdf.kernel.pdf.PdfWriter
import com.itextpdf.layout.Document
import com.itextpdf.layout.element.Paragraph
import java.io.File
import java.io.FileOutputStream
fun generatePDF(
    context: Context,
    nombre: String,
    cedula: String,
    direccion: String,
    telefono: String,
    tarjetaNumero: String,
    panes: List<Pan>
): String {
    val path = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
    val file = File(path, "Factura_${System.currentTimeMillis()}.pdf")
    val writer = PdfWriter(FileOutputStream(file))
    val pdfDoc = com.itextpdf.kernel.pdf.PdfDocument(writer)
    val document = Document(pdfDoc)

    val total = panes.sumOf { it.price * it.count }
    val iva = total * 0.15
    val totalConIva = total + iva

    document.add(Paragraph("Factura"))
    document.add(Paragraph("Nombre: $nombre"))
    document.add(Paragraph("Cédula: $cedula"))
    document.add(Paragraph("Dirección: $direccion"))
    document.add(Paragraph("Teléfono: $telefono"))
    document.add(Paragraph("Número de Tarjeta: $tarjetaNumero"))
    document.add(Paragraph("Items:"))

    panes.forEach {
        document.add(Paragraph("${it.name}: ${it.count} x ${it.price} = ${it.count * it.price}"))
    }

    document.add(Paragraph("Total: $total"))
    document.add(Paragraph("IVA (15%): $iva"))
    document.add(Paragraph("Total con IVA: $totalConIva"))

    document.close()

    return file.absolutePath
}

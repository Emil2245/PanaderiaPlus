package com.app.panaderiaplus.ui.screen

import android.annotation.SuppressLint
import android.content.Context
import android.os.Environment
import com.app.panaderiaplus.data.order.PanOrdenado
import com.itextpdf.io.font.constants.StandardFonts
import com.itextpdf.kernel.font.PdfFontFactory
import com.itextpdf.kernel.pdf.PdfWriter
import com.itextpdf.layout.Document
import com.itextpdf.layout.element.Paragraph
import java.io.File
import java.io.FileOutputStream
import java.util.UUID

@SuppressLint("DefaultLocale")
fun generatePDF(
    context: Context,
    nombre: String,
    cedula: String,
    direccion: String,
    telefono: String,
    tarjetaNumero: String,
    panes: List<PanOrdenado>
): String {
    val path = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
    val file = File(path, "Factura_${System.currentTimeMillis()}.pdf")
    val writer = PdfWriter(FileOutputStream(file))
    val pdfDoc = com.itextpdf.kernel.pdf.PdfDocument(writer)
    val document = Document(pdfDoc)

    val font = PdfFontFactory.createFont(StandardFonts.HELVETICA)
    val fontSize = 23f  // Ajustar el tamaño de la fuente aquí
    val fontMin = 19f  // Ajustar el tamaño de la fuente aquí
    val fontSizeTitle = 28f  // Ajustar el tamaño de la fuente aquí
    val fontSizeMax = 32f  // Ajustar el tamaño de la fuente aquí

    val total = panes.sumOf { it.price * it.count }
    val iva = total * 0.15
    val totalConIva = total + iva

    document.add(Paragraph("FACTURA:    Ord-" + UUID.randomUUID().toString().substring(0,8)).setFont(font).setFontSize(fontSizeMax))
    document.add(Paragraph("Nombre: $nombre").setFont(font).setFontSize(fontSize))
    document.add(Paragraph("Cédula: $cedula").setFont(font).setFontSize(fontSize))
    document.add(Paragraph("Dirección: $direccion").setFont(font).setFontSize(fontSize))
    document.add(Paragraph("Teléfono: $telefono").setFont(font).setFontSize(fontSize))
    document.add(Paragraph("Número de Tarjeta: $tarjetaNumero").setFont(font).setFontSize(fontSize))
    document.add(Paragraph("Items__________________").setFont(font).setFontSize(fontSizeTitle))
    panes.forEach {
        document.add(Paragraph("${it.name}: ${it.count} x ${it.price} = ${it.count * it.price}")
            .setFont(font)
            .setFontSize(fontMin))
    }

    document.add(Paragraph("Total: $total").setFont(font).setFontSize(fontSize))
    document.add(Paragraph("IVA (15%): $iva").setFont(font).setFontSize(fontSize))
    document.add(Paragraph("__________________________________").setFont(font).setFontSize(fontMin))
    document.add(Paragraph("Total con IVA: ${String.format("%.2f", totalConIva)}").setFont(font).setFontSize(fontSizeTitle))

    document.close()

    return file.absolutePath
}

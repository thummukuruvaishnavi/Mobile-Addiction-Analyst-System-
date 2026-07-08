package com.example.mobileaddictionanalystsystem.report

import android.content.Context
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import java.io.File
import java.io.FileOutputStream

object PdfReport {

    fun generateReport(
        context: Context,
        screenTime: String,
        socialMedia: String,
        gaming: String,
        sleep: String,
        risk: String
    ): File {

        val pdfDocument = PdfDocument()

        val pageInfo = PdfDocument.PageInfo.Builder(
            595,
            842,
            1
        ).create()

        val page = pdfDocument.startPage(pageInfo)

        val canvas = page.canvas

        val paint = Paint()

        paint.textSize = 24f
        paint.isFakeBoldText = true

        canvas.drawText(
            "Mobile Addiction Report",
            120f,
            60f,
            paint
        )

        paint.textSize = 18f
        paint.isFakeBoldText = false

        var y = 120f

        canvas.drawText("Screen Time : $screenTime", 50f, y, paint)
        y += 40

        canvas.drawText("Social Media : $socialMedia", 50f, y, paint)
        y += 40

        canvas.drawText("Gaming : $gaming", 50f, y, paint)
        y += 40

        canvas.drawText("Sleep : $sleep", 50f, y, paint)
        y += 40

        canvas.drawText("Risk Level : $risk", 50f, y, paint)
        y += 60

        paint.isFakeBoldText = true

        canvas.drawText(
            "AI Recommendation",
            50f,
            y,
            paint
        )

        paint.isFakeBoldText = false

        y += 40

        canvas.drawText(
            "• Reduce social media usage.",
            50f,
            y,
            paint
        )

        y += 30

        canvas.drawText(
            "• Take a 10-minute break every hour.",
            50f,
            y,
            paint
        )

        y += 30

        canvas.drawText(
            "• Sleep at least 7-8 hours.",
            50f,
            y,
            paint
        )

        pdfDocument.finishPage(page)

        val file = File(
            context.getExternalFilesDir(null),
            "Mobile_Addiction_Report.pdf"
        )

        pdfDocument.writeTo(FileOutputStream(file))
        pdfDocument.close()

        return file
    }
}
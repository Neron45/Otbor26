package com.example.uikit

import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily

data class Btn_main(
    val width_btn: Int,
    val height_btn: Int,
    val color: Long,
    val colortext: Long,
    val label: String,
    val shape: Int,
    val textsize: Int,
    val font: FontFamily,
    val padingtop: Int,
    val padingstart: Int,
    val enabled: Boolean
)

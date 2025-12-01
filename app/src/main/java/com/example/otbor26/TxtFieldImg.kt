package com.example.otbor26

import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.font.FontFamily

data class TxtFieldImg(
    var text: MutableState<String>,

    val width: Int,
    val heigth: Int,
    val color: Long,
    val shape: Int,

    val font: FontFamily,
    val fontsize: Int,
    val fontcolor: Long,

    val text_pl: String,
    val font_pl: FontFamily,
    val fontsize_pl: Int,
    val fontcolor_pl: Long,

    val icon: Int,
    val iconCl: Int,
)

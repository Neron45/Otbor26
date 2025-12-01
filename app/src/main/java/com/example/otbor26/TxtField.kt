package com.example.otbor26

import android.graphics.drawable.Icon
import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.font.FontFamily

data class TxtField(

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

    )

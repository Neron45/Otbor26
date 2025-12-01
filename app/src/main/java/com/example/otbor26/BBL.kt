package com.example.otbor26

import android.media.Image
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import org.w3c.dom.Text

data class BBL(
    val image: Int,
    var paddingTop: Int,
    var paddingStart: Int,
    var sizeW: Int,
    var sizeH: Int,

    var imagePaddingTop: Int,
    var imagePaddingStart: Int,
    var imageSize: Int,

    var text: String,
    var textColor: Long,
    var textSize: Int,
    var textFont: FontFamily,
    var textPaddingTop: Int,
    var textPaddingStart: Int

)

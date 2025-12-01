package com.example.otbor26

import androidx.annotation.Size
import androidx.compose.ui.text.font.FontFamily

data class Cards(

    var sizeW: Int,
    var sizeH: Int,
    var paddingTop: Int,
    var paddingStart: Int,
    var Color: Long,
    var Shape: Int,

    var text1: String,
    var text1Color: Long,
    var text1Size: Int,
    var text1Font: FontFamily,
    var text1PaddingTop: Int,
    var text1PaddingStart: Int,

    var text2: String,
    var text2Color: Long,
    var text2Size: Int,
    var text2Font: FontFamily,
    var text2PaddingTop: Int,
    var text2PaddingStart: Int,

    var price: String,
    var priceColor: Long,
    var priceSize: Int,
    var priceFont: FontFamily,
    var pricePaddingTop: Int,
    var pricePaddingStart: Int,

    var btntext: String,
    var btnColor: Long,
    var btntextColor: Long,
    var btntextSize: Int,
    var btntextFont: FontFamily,
    var btnPaddingTop: Int,
    var btnPaddingStart: Int,
    var btnshape: Int,
    var btnborderW: Int,
    var btnborderShape: Int,
    var btnborderColor: Long,
    var btnSizeH: Int,
    var btnSizeW: Int,


)

package com.example.uikit

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

var sfproreg = FontFamily(Font(com.example.uikit.R.font.sfproreg))
var sfprosemibold = FontFamily(Font(com.example.uikit.R.font.sfprosemibold))

var sfprobold = FontFamily(Font(com.example.uikit.R.font.sfprobold))

var robotomed = FontFamily(Font(com.example.uikit.R.font.robotomed))
var robotobold = FontFamily(Font(com.example.uikit.R.font.robotobold))

var click by mutableStateOf<String?>("")
var counter by mutableStateOf<Int>(0)
@Composable
fun UIKITbtn(item: Btn){
    Button(onClick = {click = item.id
        if (counter < 4) counter++},

        modifier = Modifier
            .height(item.height_btn.dp)
            .width(item.width_btn.dp)
            .clip(CircleShape),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (click == item.id) Color(0xFF1A6FEE) else Color(0xFFF5F5F9),
            contentColor = if (click == item.id) Color(0xFFFFFFFF) else Color(0xFF000000),
        )

    ) {
        Text(
            text = item.id,
            fontSize = 24.sp,
            fontFamily = sfprobold
        )
    }
}
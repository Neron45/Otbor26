package com.example.uikit2

import android.R.attr.path
import android.graphics.Color
import android.graphics.drawable.Icon
import android.media.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val CustomIcon1: ImageVector
    get() {
        return ImageVector.Builder(
            name = "CustomIcon1",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = null,
                stroke = null
            ) {
                // Добавьте здесь path данные для вашей иконки
                // Пример: треугольник
                moveTo(12f, 2f)
                lineTo(22f, 20f)
                lineTo(2f, 20f)
                close()
            }
        }.build()
    }

@Composable
fun CustomIcon1(
) {
    Image(
        painter = painterResource(R.drawable.)
    )
}
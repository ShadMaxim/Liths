package com.example.serenitysoul.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

data class SerenitySoulShapes(
    //val verySmall: RoundedCornerShape = RoundedCornerShape(2.dp),
    //val small: RoundedCornerShape = RoundedCornerShape(4.dp),
    //val little: RoundedCornerShape = RoundedCornerShape(6.dp),
    val compact: RoundedCornerShape = RoundedCornerShape(8.dp),
    //val standard: RoundedCornerShape = RoundedCornerShape(10.dp),
    //val medium: RoundedCornerShape = RoundedCornerShape(12.dp),
    //val large: RoundedCornerShape = RoundedCornerShape(14.dp),
    //val big: RoundedCornerShape = RoundedCornerShape(16.dp),
    val extraLarge: RoundedCornerShape = RoundedCornerShape(20.dp),
    //val huge: RoundedCornerShape = RoundedCornerShape(24.dp),
)

val LocalSerenitySoulShapes = staticCompositionLocalOf { SerenitySoulShapes() }

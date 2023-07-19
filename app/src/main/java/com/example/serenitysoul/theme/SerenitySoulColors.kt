package com.example.serenitysoul.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class SerenitySoulColors(
    green: Color,
    red: Color,
) {

    var green by mutableStateOf(green)
        private set

    var red by mutableStateOf(red)
        private set

    fun copy(
        green: Color = this.green,
        red: Color = this.red

    ) = SerenitySoulColors(
        green = green,
        red = red
    )

    fun updateColorsFrom(other: SerenitySoulColors) {
        green = other.green
        red = other.red
    }


}

val LocalSerenitySoulColors = staticCompositionLocalOf { lightColorsScheme() }

fun lightColorsScheme() = SerenitySoulColors(
    green = neutralGreen,
    red = neutralRed
)

fun darkColorsScheme() = SerenitySoulColors(
    green = neutralGreen.copy(alpha = 0.5f),
    red = neutralRed.copy(alpha = 0.5f)
)
package com.example.serenitysoul.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class SerenitySoulColors(
    green: Color,
    red: Color,
    settingsBackgroundColor: Color,
) {

    var green by mutableStateOf(green)
        private set

    var red by mutableStateOf(red)
        private set

    var settingsBackgroundColor by mutableStateOf(settingsBackgroundColor)
        private set

    fun copy(
        green: Color = this.green,
        red: Color = this.red,
        settingsBackgroundColor: Color = this.settingsBackgroundColor,

    ) = SerenitySoulColors(
        green = green,
        red = red,
        settingsBackgroundColor = settingsBackgroundColor
    )

    fun updateColorsFrom(other: SerenitySoulColors) {
        green = other.green
        red = other.red
        settingsBackgroundColor = other.settingsBackgroundColor
    }


}

val LocalSerenitySoulColors = staticCompositionLocalOf { lightColorsScheme() }

fun lightColorsScheme() = SerenitySoulColors(
    green = neutralGreen,
    red = neutralRed,
    settingsBackgroundColor = lightSettingsBackgroundColor
)

fun darkColorsScheme() = SerenitySoulColors(
    green = neutralGreen.copy(alpha = 0.5f),
    red = neutralRed.copy(alpha = 0.5f),
    settingsBackgroundColor = darkSettingsBackgroundColor
)
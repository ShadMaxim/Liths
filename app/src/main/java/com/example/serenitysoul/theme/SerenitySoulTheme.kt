package com.example.serenitysoul.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember

@Composable
fun SerenitySoulTheme(

    shapes: SerenitySoulShapes = SerenitySoulTheme.shapes,
    typography: SerenitySoulTypography = SerenitySoulTheme.typography,
    colors: SerenitySoulColors = SerenitySoulTheme.colorScheme,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,

) {
    val currentColor = remember { if (darkTheme) darkColorsScheme() else colors }
    val rememberedColors = remember { currentColor.copy() }.apply { updateColorsFrom(currentColor) }
    CompositionLocalProvider(
        LocalSerenitySoulColors provides rememberedColors,
        LocalSerenitySoulShapes provides shapes,
        LocalSerenitySoulTypography provides typography
    ) {
        ProvideTextStyle(value = typography.defaultStyle, content = content)
    }
}

object SerenitySoulTheme {

    val colorScheme: SerenitySoulColors
        @Composable
        @ReadOnlyComposable
        get() = LocalSerenitySoulColors.current

    val typography: SerenitySoulTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalSerenitySoulTypography.current

    val shapes: SerenitySoulShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalSerenitySoulShapes.current
}
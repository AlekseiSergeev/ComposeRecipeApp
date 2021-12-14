package com.example.composerecipeapp.presentation.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = Orange700,
    primaryVariant = Black1,
    onPrimary = White,
    secondary = Black1,
    onSecondary = White,
    error = RedErrorLight,
    background = Black2,
    onBackground = White,
    surface = Black1,
    onSurface = White,
)

private val LightColorPalette = lightColors(
    primary = Blue500,
    primaryVariant = Blue800,
    onPrimary = Black2,
    secondary = White,
    secondaryVariant = Teal300,
    onSecondary = Black2,
    error = RedErrorDark,
    onError = RedErrorLight,
    background = Grey1,
    onBackground = Black2,
    surface = White,
    onSurface = Black2,
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val systemUiController = rememberSystemUiController()
        systemUiController.setSystemBarsColor(color = colors.primaryVariant)

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
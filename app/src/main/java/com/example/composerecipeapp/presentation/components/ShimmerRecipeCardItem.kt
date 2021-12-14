package com.example.composerecipeapp.presentation.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@Composable
fun ShimmerRecipeCardItem(
    colors: List<Color>,
    cardHeight: Dp,
    widthPx: Float,
    heightPx: Float,
    padding: Dp
) {
    val infiniteTransition = rememberInfiniteTransition()

    val xPosition by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = widthPx,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1500,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        )
    )

    val yPosition by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = heightPx,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1500,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        )
    )

    val gradientWidth = 0.1f * widthPx

    val brush = Brush.linearGradient(
        colors = colors,
        start = Offset(xPosition - gradientWidth, yPosition - gradientWidth),
        end = Offset(xPosition + gradientWidth, yPosition + gradientWidth)
    )

    Column(modifier = Modifier.padding(padding)) {
        Surface(shape = MaterialTheme.shapes.small) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(cardHeight)
                    .background(brush = brush)
            )
        }
    }
}
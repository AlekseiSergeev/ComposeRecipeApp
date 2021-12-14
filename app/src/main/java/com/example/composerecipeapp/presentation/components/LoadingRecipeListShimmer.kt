package com.example.composerecipeapp.presentation.components


import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun LoadingRecipeListShimmer (
    cardHeight: Dp,
    padding: Dp = 16.dp
) {
    val colors = listOf(
        Color.LightGray.copy(alpha = 0.9f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.9f),
    )

    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {

        val cardWidthPx = with(LocalDensity.current){
            ((maxWidth - (padding*2)).toPx())
        }
        val cardHeightPx = with(LocalDensity.current){
            ((maxHeight - padding).toPx())
        }

        val scrollState = rememberScrollState()
        Column(Modifier.verticalScroll(scrollState)) {
            repeat(5) {
                ShimmerRecipeCardItem(
                    colors = colors,
                    cardHeight = cardHeight,
                    widthPx = cardWidthPx,
                    heightPx = cardHeightPx,
                    padding = padding
                )
            }
        }
    }
}
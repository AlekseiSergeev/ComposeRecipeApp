package com.example.composerecipeapp.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.composerecipeapp.R


private val Lobster = FontFamily(Font(R.font.lobster_regular))
private val Merienda = FontFamily(Font(R.font.merienda_regular))

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h2 = TextStyle(
        fontFamily = Lobster,
        fontSize = 26.sp
    ),
    h3 = TextStyle(
        fontFamily = Merienda,
        fontSize = 24.sp
    ),
    h4 = TextStyle(
        fontFamily = Merienda,
        fontSize = 20.sp
    ),
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)
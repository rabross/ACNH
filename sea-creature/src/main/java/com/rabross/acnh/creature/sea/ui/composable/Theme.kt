package com.rabross.acnh.creature.sea.ui.composable

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun MyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) DarkColors else LightColors,
        typography = MyTypography,
        content = content
    )
}

private val DarkColors = darkColors()
private val LightColors = lightColors().copy(
    onBackground = Color(0xDE000000)
)

private val MyTypography = Typography()
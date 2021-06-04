package com.rabross.acnh.creature.sea.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.glide.rememberGlidePainter
import com.rabross.acnh.creature.sea.R
import com.rabross.acnh.creature.sea.ui.model.SeaCreatureDetail

@Composable
internal fun SeaCreatureDetailComposable(
    detail: SeaCreatureDetail,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(24.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(
            painter = rememberGlidePainter(
                request = detail.imageUrl,
                previewPlaceholder = R.drawable.ic_baseline_anchor_24
            ),
            contentDescription = "${detail.name} image",
        )
        Text(
            detail.name,
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp,
            color = MaterialTheme.colors.onBackground
        )
        Spacer(Modifier.size(16.dp))
        Text(
            text = "\"${detail.catchphrase}\"",
            fontSize = 24.sp,
            color = MaterialTheme.colors.onBackground
        )
        Spacer(Modifier.size(24.dp))
        Text(
            text = stringResource(R.string.sea_creature_speed_template, detail.speed),
            fontSize = 16.sp,
            color = MaterialTheme.colors.onBackground
        )
    }
}

@Preview
@Composable
private fun ComposablePreview() {
    SeaCreatureDetailComposable(
        SeaCreatureDetail(
            "Fake", "", "I am fake", "fast"
        )
    )
}

@Composable
fun MyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) DarkColors else LightColors,
        content = content
    )
}

internal val DarkColors = darkColors()
internal val LightColors = lightColors()

package com.rabross.acnh.creature.sea.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.glide.rememberGlidePainter
import com.rabross.acnh.creature.sea.ui.model.SeaCreatureDetail

@Composable
internal fun SeaCreatureDetailComposable(
    detail: SeaCreatureDetail,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(
            painter = rememberGlidePainter(detail.imageUrl),
            contentDescription = "${detail.name} image"
        )
        Text(
            detail.name,
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp
        )
        Spacer(Modifier.size(16.dp))
        Text(
            detail.catchphrase,
            fontSize = 24.sp
        )
        Spacer(Modifier.size(24.dp))
        Text(
            "Speed: ${detail.speed}",
            fontSize = 16.sp,
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

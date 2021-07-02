package com.rabross.acnh.creature.sea.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
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
        modifier = modifier
            .background(MaterialTheme.colors.background)
            .padding(24.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(
            painter = rememberGlidePainter(
                request = detail.imageUrl
            ),
            contentDescription = "${detail.name} image",
        )
        Text(
            detail.name,
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h4
        )
        Spacer(modifier.size(24.dp))
        Text(
            text = "\"${detail.catchphrase}\"",
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier.size(24.dp))
        Text(
            text = stringResource(R.string.sea_creature_speed_template, detail.speed),
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.body1
        )
    }
}
package com.rabross.acnh.creature.sea.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.glide.rememberGlidePainter
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.collectAsState
import com.rabross.acnh.creature.sea.ui.SeaCreatureViewModel
import com.rabross.acnh.creature.sea.ui.SeaCreatureViewState
import com.rabross.acnh.creature.sea.ui.mappers.toSeaCreature
import com.rabross.acnh.creature.sea.ui.model.SeaCreature
import com.rabross.acnh.creature.sea.ui.model.SeaCreatures
import com.rabross.acnh.content.creature.SeaCreature as SeaCreatureEntity

@Composable
internal fun SeaCreaturePageComposable(
    viewModel: SeaCreatureViewModel,
    modifier: Modifier = Modifier
) {
    val seaCreaturesState = viewModel.seaCreatures.collectAsState(initial = SeaCreatureViewState.Loading)
    when(seaCreaturesState.value){
        is SeaCreatureViewState.Loaded -> {
            SeaCreatureLoaded((seaCreaturesState.value as SeaCreatureViewState.Loaded).seaCreatures, modifier) { seaCreature ->
                viewModel.onClick(seaCreature)
            }
        }
        SeaCreatureViewState.Error -> {}
        SeaCreatureViewState.Loading -> {}
    }
}

@Composable
private fun SeaCreatureLoaded(seaCreatures: SeaCreatures, modifier: Modifier = Modifier, onClick: (SeaCreatureEntity) -> Unit){
    LazyColumn(modifier = modifier) {
        items(seaCreatures) { seaCreature ->
            SeaCreatureItem(seaCreature.toSeaCreature(), modifier.clickable { onClick(seaCreature) })
        }
    }
}

@Composable
private fun SeaCreatureItem(
    seaCreature: SeaCreature,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(MaterialTheme.colors.background)
            .padding(24.dp)
    ) {
        Image(
            painter = rememberGlidePainter(
                request = seaCreature.iconUrl
            ),
            contentDescription = "${seaCreature.name} image",
        )
        Text(
            seaCreature.name,
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h4
        )
    }
}
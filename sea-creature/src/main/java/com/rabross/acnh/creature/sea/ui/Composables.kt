package com.rabross.acnh.creature.sea.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rabross.acnh.creature.sea.ui.composable.SeaCreatureDetailComposable
import com.rabross.acnh.creature.sea.ui.model.SeaCreatureDetail

@Preview
@Composable
private fun ComposablePreview() {
    SeaCreatureDetailComposable(
        SeaCreatureDetail(
            "Fake", "", "I am fake", "fast"
        )
    )
}

package com.rabross.acnh.creature.sea.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import javax.inject.Inject

class SeaCreatureDetailsFragment
@Inject constructor() : Fragment() {

    private val args by navArgs<SeaCreatureDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return ComposeView(requireContext()).apply {
            setContent {
                MyTheme {
                    SeaCreatureDetailComposable(detail = args.seaCreatureDetail)
                }
            }
        }
    }
}

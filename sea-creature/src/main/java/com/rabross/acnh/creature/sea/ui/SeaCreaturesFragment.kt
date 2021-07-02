package com.rabross.acnh.creature.sea.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.rabross.acnh.core.viewmodel.ViewModelFactory
import com.rabross.acnh.creature.sea.ui.composable.MyTheme
import com.rabross.acnh.creature.sea.ui.composable.SeaCreaturePageComposable
import javax.inject.Inject

class SeaCreaturesFragment
@Inject constructor(
    viewModelFactory: ViewModelFactory
) : Fragment() {

    private val viewModel by viewModels<SeaCreatureViewModel> { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MyTheme {
                    SeaCreaturePageComposable(viewModel)
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.handleClicks { directions -> findNavController().navigate(directions) }
        viewModel.fetch()
    }
}

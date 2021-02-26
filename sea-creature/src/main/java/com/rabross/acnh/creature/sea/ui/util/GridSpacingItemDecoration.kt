package com.rabross.acnh.creature.sea.ui.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

internal class GridSpacingItemDecoration(private val spacing: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val span = (parent.layoutManager as? GridLayoutManager)?.spanCount ?: 1
        val position = parent.getChildAdapterPosition(view)
        val column = position % span

        outRect.apply {
            left = spacing - column * spacing / span
            right = (column + 1) * spacing / span
            top = if (position < span) spacing else 0
            bottom = spacing
        }
    }
}

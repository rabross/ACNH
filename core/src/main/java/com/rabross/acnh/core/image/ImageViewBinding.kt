package com.rabross.acnh.core.image

import android.widget.ImageView
import androidx.databinding.BindingAdapter

class ImageViewBinding(private val imageLoader: ImageLoader) {

    @BindingAdapter("loadUrl")
    fun ImageView.loadImage(url: String) {
        imageLoader.load(this, url)
    }
}




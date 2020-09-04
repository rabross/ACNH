package com.rabross.acnh.core.image

import android.widget.ImageView
import androidx.databinding.BindingAdapter

class ImageViewBinding(val imageLoader: ImageLoader) {

    @BindingAdapter("loadUrl")
    fun loadImage(view: ImageView, url: String) {
        imageLoader.load(view, url)
    }
}




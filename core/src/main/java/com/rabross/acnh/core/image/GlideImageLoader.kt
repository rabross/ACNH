package com.rabross.acnh.core.image

import android.widget.ImageView
import com.bumptech.glide.Glide

class GlideImageLoader : ImageLoader {
    override fun load(imageView: ImageView, url: String) {
        Glide.with(imageView).load(url).into(imageView)
    }
}
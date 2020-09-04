package com.rabross.acnh.core.image

import android.widget.ImageView

interface ImageLoader {
    fun load(imageView: ImageView, url: String)
}
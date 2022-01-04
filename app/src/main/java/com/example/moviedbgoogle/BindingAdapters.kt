package com.example.moviedbgoogle

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.load
import com.example.moviedbgoogle.network.IMAGE_URL

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView,
              imgUrl: String?) {

    imgUrl?.let {
        val unitedUrl = IMAGE_URL+imgUrl
        val imgUri = unitedUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}
package com.example.melitest.presentation.adapter

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.melitest.R

@BindingAdapter("imageUrl")
fun setImageGlide(container: AppCompatImageView, url: String?) {
    Glide.with(container.context)
        .load(url ?: R.drawable.not_found_image)
        .placeholder(R.drawable.image_loader)
        .centerInside()
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .error(R.drawable.not_found_image)
        .into(container)

}

@BindingAdapter("visibleGone")
fun showHide(view: View, show: Boolean) {
    if (show) view.visibility = View.VISIBLE else view.visibility = View.GONE
}

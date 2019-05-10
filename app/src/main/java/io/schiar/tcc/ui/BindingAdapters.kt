package io.schiar.tcc.ui

import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import io.schiar.tcc.R
import io.schiar.tcc.utilities.BitmapLoader
import kotlinx.android.synthetic.main.amenity.view.*

object BindingAdapters {
    @BindingAdapter("stars")
    @JvmStatic
    fun setStars(layout: LinearLayout, stars: Int?) {
        layout.removeAllViews()
        for (i in 0 until (stars ?: 0)) {
            val starView = LayoutInflater.from(layout.context).inflate(R.layout.view_star, layout, false)
            layout.addView(starView)
        }
    }

    @BindingAdapter("bitmapLoader")
    @JvmStatic
    fun setBitmap(imageView: ImageView, bitmapLoader: BitmapLoader?) {
        bitmapLoader?.loadInto(imageView)
    }

    @BindingAdapter("amenities")
    @JvmStatic
    fun setAmenities(layout: LinearLayout, amenities: List<String>) {
        for (amenity in amenities) {
            val amenityView = LayoutInflater.from(layout.context).inflate(R.layout.amenity, layout, false)
            amenityView.name.text = String.format(layout.context.getString(R.string.amenity), amenity)
            layout.addView(amenityView)
        }
    }
}
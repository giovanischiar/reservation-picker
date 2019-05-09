package io.schiar.tcc.utilities

import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator

class BitmapLoader(urlString: String) {
    private val requestCreator: RequestCreator = Picasso.get().load(urlString)

    fun loadInto(imageView: ImageView) {
        requestCreator.into(imageView)
    }
}

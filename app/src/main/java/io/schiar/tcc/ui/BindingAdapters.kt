package io.schiar.tcc.ui

import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import io.schiar.tcc.R
import io.schiar.tcc.utilities.BitmapLoader
import kotlinx.android.synthetic.main.amenity.view.*

/**
 * Utilizado para tratamento de dados do ViewModel para serem apresentados na View.
 */
object BindingAdapters {
    /**
     * Carrega um XML de estrela para cada quantidade de estrelas definida.
     * @param layout onde carregará as estrelas.
     * @param stars quantidade de estrelas.
     */
    @BindingAdapter("stars")
    @JvmStatic
    fun setStars(layout: LinearLayout, stars: Int?) {
        layout.removeAllViews()
        for (i in 0 until (stars ?: 0)) {
            val starView = LayoutInflater.from(layout.context).inflate(R.layout.view_star, layout, false)
            layout.addView(starView)
        }
    }

    /**
     * Carrega uma imagem em um componente de imagem.
     * @param imageView componente de imagem.
     * @param bitmapLoader carregador da imagem.
     */
    @BindingAdapter("bitmapLoader")
    @JvmStatic
    fun setBitmap(imageView: ImageView, bitmapLoader: BitmapLoader?) {
        bitmapLoader?.loadInto(imageView)
    }

    /**
     * Formata uma lista de amenidades a ser exibida.
     * @param layout onde carregará as amenidades.
     * @param stars dados das amenidades.
     */
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
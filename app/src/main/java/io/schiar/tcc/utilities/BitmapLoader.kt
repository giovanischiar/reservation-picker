package io.schiar.tcc.utilities

import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator

/**
 * Carrega imagens.
 * @param urlString URL de uma imagem.
 * @property requestCreator carregador de imagens em URL.
 */
class BitmapLoader(urlString: String) {
    private val requestCreator: RequestCreator = Picasso.get().load(urlString)

    /**
     * Carrega em uma [ImageView] uma imagem trazida da WEB
     */
    fun loadInto(imageView: ImageView) {
        requestCreator.into(imageView)
    }
}

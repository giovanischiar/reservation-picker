package io.schiar.tcc.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.schiar.tcc.R
import io.schiar.tcc.viewmodel.Preview
import kotlinx.android.synthetic.main.adapter_preview.view.*

/**
 * Responsável por configurar a exibição dos dados de lista de hotéis e carros.
 * @property previews dados da lista para ser exibido
 * @property context usado para carregar o XML que representa um item da lista
 * @property onClickPreviewListener usado para definir o método que é chamado quando um item de lista é clicado
 */
class PreviewAdapter(
    private val previews: List<Preview>,
    private val context: Context,
    private val onClickPreviewListener: OnClickPreviewListener): RecyclerView.Adapter<PreviewAdapter.ViewHolder>() {

    /**
     * Carrega o XML que representa um item da lista e passa para ser configurado no [ViewHolder]
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_preview, parent, false)
        return ViewHolder(view, onClickPreviewListener)
    }

    /**
     * Necessário para o [RecyclerView], mostra a quantidade de itens da lista.
     * @return quantidade de itens da lista
     */
    override fun getItemCount(): Int {
        return previews.size
    }

    /**
     * Chama método para configurar cada item da lista.
     * @param holder responsável pela configuração de cada item da lista.
     * @param position índice do item da lista
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(previews[position], position)
    }

    /**
     * Usada para a configuração de cada item da lista.
     * @param itemView View do layout de um item da lista.
     * @param onClickPreviewListener listener disparado quando um item da lista é clicado.
     */
    class ViewHolder(
        itemView: View,
        private val onClickPreviewListener: OnClickPreviewListener
    ): RecyclerView.ViewHolder(itemView) {

        /**
         * Configura um item da lista.
         * @param preview dados a servem mostrados
         * @param index índice do dado
         */
        fun bindView(preview: Preview, index:Int) {
            preview.photo.loadInto(itemView.photo)
            itemView.name.text = preview.name
            itemView.setOnClickListener { onClickPreviewListener.onPreviewClick(index, itemView) }
        }

    }

}
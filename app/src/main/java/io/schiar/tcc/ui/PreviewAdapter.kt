package io.schiar.tcc.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.schiar.tcc.R
import io.schiar.tcc.viewmodel.Preview
import kotlinx.android.synthetic.main.adapter_preview.view.*

class PreviewAdapter(
    private val previews: List<Preview>,
    private val context: Context,
    private val onClickPreviewListener: OnClickPreviewListener): RecyclerView.Adapter<PreviewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_preview, parent, false)
        return ViewHolder(view, onClickPreviewListener)
    }

    override fun getItemCount(): Int {
        return previews.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(previews[position], position)
    }

    class ViewHolder(
        itemView: View,
        private val onClickPreviewListener: OnClickPreviewListener
    ): RecyclerView.ViewHolder(itemView) {

        fun bindView(preview: Preview, index:Int) {
            preview.photo.loadInto(itemView.photo)
            itemView.name.text = preview.name
            itemView.setOnClickListener { onClickPreviewListener.onPreviewClick(index, itemView) }
        }

    }

}
package com.tran.valentin.lbctest.ui.recyclerviewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.tran.valentin.lbctest.R
import com.tran.valentin.lbctest.ui.data.AlbumUiData

class AlbumRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val image: ImageView = itemView.findViewById(R.id.image)
    private val title: TextView = itemView.findViewById(R.id.title)

    fun bind(data: AlbumUiData) {
        Glide.with(itemView.context).load(data.imageUrl)
            .apply(RequestOptions().placeholder(R.drawable.ic_leboncoin).error(R.drawable.ic_leboncoin))
            .into(image)
        title.text = data.title
    }
}
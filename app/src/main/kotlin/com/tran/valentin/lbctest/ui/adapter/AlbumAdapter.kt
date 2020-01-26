package com.tran.valentin.lbctest.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tran.valentin.lbctest.R
import com.tran.valentin.lbctest.ui.data.AlbumUiData
import com.tran.valentin.lbctest.ui.recyclerviewholder.AlbumRecyclerViewHolder

class AlbumAdapter : ListAdapter<AlbumUiData, RecyclerView.ViewHolder>(diffCallback) {
    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<AlbumUiData>() {
            override fun areItemsTheSame(oldItem: AlbumUiData, newItem: AlbumUiData): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: AlbumUiData, newItem: AlbumUiData): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AlbumRecyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.viewholder_album,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as AlbumRecyclerViewHolder
        holder.bind(getItem(position))
    }
}
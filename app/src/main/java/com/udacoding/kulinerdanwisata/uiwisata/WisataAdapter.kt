package com.udacoding.kulinerdanwisata.uiwisata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.udacoding.kulinerdanwisata.R
import com.udacoding.kulinerdanwisata.model.DataItem
import kotlinx.android.synthetic.main.item_kuliner.view.*

class WisataAdapter(val data: List<DataItem?>?)
    : RecyclerView.Adapter<WisataAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_kuliner,parent,false)
        return MyHolder(view)
    }

    override fun getItemCount() = data?.size ?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
//        data?.get(position)?.let { holder.onBind(it) }
        holder.onBind(data?.get(position))
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(dataItem: DataItem?){
            Glide.with(itemView.context)
                .load(dataItem?.gambar)
                .into(itemView.imageKuliner)

            itemView.titleKuliner.text = dataItem?.namaTempat
        }
    }
}
package com.example.rempahnusantara

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class listRempahAdapter (private val listRempah: ArrayList<Rempah>) : RecyclerView.Adapter<listRempahAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }


    class ListViewHolder (itemView: View)  : RecyclerView.ViewHolder (itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvHarga: TextView = itemView.findViewById(R.id.tv_item_harga)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)

    }


    override fun onCreateViewHolder(
        viewGroup: ViewGroup, i: Int
    ): listRempahAdapter.ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_rempah, viewGroup, false)
        return ListViewHolder(view)

    }

    override fun getItemCount(): Int {
        return listRempah.size
    }

    override fun onBindViewHolder(holder: listRempahAdapter.ListViewHolder, position: Int) {
        val rempah = listRempah[position]

        Glide.with(holder.itemView.context)
            .load(rempah.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)

        holder.tvName.text = rempah.name
        holder.tvHarga.text = rempah.harga

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listRempah[holder.adapterPosition])

            val moveDetailRempah = Intent(mContext, ActivityRempahDetail::class.java)
            moveDetailRempah.putExtra(ActivityRempahDetail.EXTRA_NAME, rempah.name)
            moveDetailRempah.putExtra(ActivityRempahDetail.EXTRA_KHASIAT, rempah.khasiat)
            moveDetailRempah.putExtra(ActivityRempahDetail.EXTRA_HARGA, rempah.harga)
            moveDetailRempah.putExtra(ActivityRempahDetail.EXTRA_DETAIL, rempah.detail)
            moveDetailRempah.putExtra(ActivityRempahDetail.EXTRA_FOTO, rempah.photo)
            mContext.startActivity(moveDetailRempah)

        }

    }


    interface OnItemClickCallback {
        fun onItemClicked(data: Rempah)
    }

}
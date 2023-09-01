package com.example.practice

import android.content.Context
import android.icu.text.DecimalFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.databinding.ActivityDetailBinding
import com.example.practice.databinding.ItemRecyclerviewBinding

class MyAdapter(val mItems: MutableList<MyItem>) : RecyclerView.Adapter<MyAdapter.Holder>() {
    private val dec = DecimalFormat("#,###")

    interface ItemClick {
        fun onClick(view : View, position : Int)
    }

    var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)


    }


    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }
        holder.iconImageView.setImageResource(mItems[position].aIcon)
        holder.name.text = mItems[position].aName
        holder.price.text = dec.format(mItems[position].aPrice.toDouble()) + "원"
        holder.address.text = mItems[position].aAddress
        holder.good.text = mItems[position].aLike.toString()
        holder.chat.text = mItems[position].aChat.toString()
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    inner class Holder(val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val iconImageView = binding.iconItem
        val name = binding.textItem1
        val price = binding.textItem4
        val address = binding.textItem5
        val good = binding.textItem6
        val chat = binding.textItem7
    }
}
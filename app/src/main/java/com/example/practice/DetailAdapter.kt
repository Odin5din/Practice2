//package com.example.practice
//
//import android.content.Context
//import android.icu.text.DecimalFormat
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.BaseAdapter
//import android.widget.ImageView
//import android.widget.TextView
//import android.content.Intent
//import androidx.activity.result.ActivityResultLauncher
//import androidx.recyclerview.widget.RecyclerView
//import com.example.practice.databinding.ActivityDetailBinding
//import com.example.practice.databinding.ItemRecyclerviewBinding
//
//class DetailAdapter(val mItems: MutableList<MyItem>) : RecyclerView.Adapter<DetailAdapter.DetailHolder>() {
//    private val dec = DecimalFormat("#,###")
//
//    interface ItemClick {
//        fun onClick(view : View, position : Int)
//    }
//
//    var itemClick : ItemClick? = null
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailHolder {
//        val detailBinding = ActivityDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return DetailHolder(detailBinding)
//
//
//    }
//
//    override fun onBindViewHolder(holder: DetailHolder, position: Int) {
//        holder.itemView.setOnClickListener {
//            itemClick?.onClick(it, position)
//        }
//        holder.detailImageView.setImageResource(mItems[position].aIcon)
//        holder.detailPrice.text = dec.format(mItems[position].aPrice.toDouble())
//        holder.detailName.text = mItems[position].aName
//        holder.detailAddress.text = mItems[position].aAddress
//        holder.seller.text = mItems[position].aSeller
//        holder.intro.text = mItems[position].aIntro
//
//    }
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    override fun getItemCount(): Int {
//        return mItems.size
//    }
//
//    inner class DetailHolder(val detailBinding: ActivityDetailBinding) : RecyclerView.ViewHolder(detailBinding.root ) {
//        val seller = detailBinding.txtDetailCenter1
//        val detailAddress = detailBinding.txtDetailCenter2
//        val detailName = detailBinding.txtDetailName
//        val intro = detailBinding.txtDetailIntro
//        val detailPrice = detailBinding.txtDetailPrice
//        val detailImageView = detailBinding.imgDetail1
//    }
//
//
//
//
//
//}
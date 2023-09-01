package com.example.practice

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class MyItem(
    val aIcon: Int,
    val aName: String,
    val aIntro: String,
    val aSeller: String,
    val aPrice: Int,
    val aAddress: String,
    val aLike: Int,
    val aChat: Int,
//    var isLike: Boolean
) : Parcelable {

}


package com.example.practice

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Build
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practice.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    private val dec = DecimalFormat("#,###")

//    private var isLike = false

    private val item: MyItem? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Constants.ITEM_OBJECT, MyItem::class.java)
        } else {
            intent.getParcelableExtra<MyItem>(Constants.ITEM_OBJECT)

        }
    }

    private val itemPosition: Int by lazy {
        intent.getIntExtra(Constants.ITEM_INDEX,0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.imgDetail1.setImageDrawable(item?.let{
            ResourcesCompat.getDrawable(
                resources,
                it.aIcon,
                null
            )
        })

        binding.txtDetailPrice.text = dec.format(item?.aPrice)
        binding.txtDetailCenter1.text = item?.aSeller
        binding.txtDetailCenter2.text = item?.aAddress
        binding.txtDetailName.text = item?.aName
        binding.txtDetailIntro.text = item?.aIntro
//        binding.detailIconBottom



//        isLike = item.?.isLike == true





    }
}

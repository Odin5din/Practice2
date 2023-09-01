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
import com.google.android.material.snackbar.Snackbar

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    private val dec = DecimalFormat("#,###")

    private var isLike = false

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
        binding.imgBack.setOnClickListener{
            back()
        }

        binding.detailIconBottom.setOnClickListener {
            if (!isLike) {
                binding.detailIconBottom.setImageResource(R.drawable.pullheart)

                Snackbar.make(binding.constLayout, "관심 목록에 추가되었습니다.", Snackbar.LENGTH_SHORT).show()
                isLike = true

            } else {
                binding.detailIconBottom.setImageResource(R.drawable.heart)
                isLike = false
            }
        }
    }



//        isLike = item.?.isLike == true



    fun back() {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("itemIndex", itemPosition)
            putExtra("isLike", isLike)
        }
        setResult(RESULT_OK, intent)
        if (!isFinishing) finish()
    }

    override fun onBackPressed() {
        back()
    }
}


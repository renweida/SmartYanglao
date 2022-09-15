package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.myapplication.databinding.ActivityJiZhongJianCeBinding
import com.example.myapplication.databinding.ItemJizhongjianceBinding

class JiZhongJianCeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJiZhongJianCeBinding
    val list = mutableListOf(
        ItemData("60%", "60~70岁", "中等", "每天1小时"),
        ItemData("22%", "60~70岁", "中等", "每天1小时"),
        ItemData("38%", "60~70岁", "中等", "每天1小时"),
        ItemData("99%", "60~70岁", "中等", "每天1小时"),
        ItemData("60%", "60~70岁", "中等", "每天1小时"),
        ItemData("22%", "60~70岁", "中等", "每天1小时"),
        ItemData("38%", "60~70岁", "中等", "每天1小时"),
        ItemData("99%", "60~70岁", "中等", "每天1小时"),
        ItemData("99%", "60~70岁", "中等", "每天1小时")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJiZhongJianCeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.titleBar.textView.text = "集中检测"
        binding.titleBar.button.setOnClickListener {
            finish()
        }
        binding.listView.adapter = object : BaseAdapter() {
            override fun getCount() = list.size

            override fun getItem(position: Int) = null

            override fun getItemId(position: Int) = 0L

            @SuppressLint("ViewHolder", "SetTextI18n")
            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                val itemJizhongjianceBinding =
                    ItemJizhongjianceBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
                itemJizhongjianceBinding.textView17.text = "入住率：" + list[position].ruzhulv
                itemJizhongjianceBinding.textView18.text = "老人的年龄分布" + list[position].nianlingfenbu
                itemJizhongjianceBinding.textView20.text = "平均运动量：" + list[position].yundongliang
                itemJizhongjianceBinding.textView16.text = "平均户外活动时间：" + list[position].huwaihuodong
                return itemJizhongjianceBinding.root
            }
        }
    }
    data class ItemData(val ruzhulv: String, val nianlingfenbu: String, val yundongliang: String, val huwaihuodong: String)
}
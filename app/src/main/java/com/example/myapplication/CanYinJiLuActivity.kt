package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.myapplication.databinding.ActivityCanYinJiLuBinding
import com.example.myapplication.databinding.ItemCanyinBinding

class CanYinJiLuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCanYinJiLuBinding
    val list = mutableListOf(
        ItemData("张三","一个馒头",  "Very Good！"),
        ItemData("李四","一碗泡面",  "Very Good！"),
        ItemData("王五","一盘米饭",  "Very Good！"),
        ItemData("张三","一根玉米",  "Very Good！"),
        ItemData("李四","一个馒头",  "Very Good！"),
        ItemData("王五","一碗泡面",  "Very Good！"),
        ItemData("张三","一盘米饭",  "Very Good！"),
        ItemData("李四","一根玉米",  "Very Good！"),
        ItemData("王五","一碗泡面",  "Very Good！")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCanYinJiLuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.titleBar.textView.text = "餐饮记录"
        binding.titleBar.button.setOnClickListener {
            finish()
        }
        binding.listView.adapter = object : BaseAdapter() {
            override fun getCount() = list.size

            override fun getItem(position: Int) = null

            override fun getItemId(position: Int) = 0L

            @SuppressLint("ViewHolder")
            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                val itemCanyinBinding =
                    ItemCanyinBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
                itemCanyinBinding.textView17.text = "姓名：" + list[position].name
                itemCanyinBinding.textView18.text = "餐饮状况：" + list[position].canyin
                itemCanyinBinding.textView20.text = "服务人员评价：" + list[position].pingjia
                return itemCanyinBinding.root
            }
        }
    }
    data class ItemData(val name: String, val canyin: String, val pingjia: String)
}
package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.myapplication.databinding.ActivityXunJianJiLuBinding
import com.example.myapplication.databinding.ItemXunjianBinding

class XunJianJiLuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityXunJianJiLuBinding
    val list = mutableListOf(
        ItemData("301", "张三", "良好"),
        ItemData("208", "李四", "正常"),
        ItemData("103", "王五", "良好"),
        ItemData("301", "张三", "良好"),
        ItemData("208", "李四", "正常"),
        ItemData("103", "王五", "良好"),
        ItemData("301", "张三", "良好"),
        ItemData("208", "李四", "正常"),
        ItemData("103", "王五", "良好")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityXunJianJiLuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.titleBar.textView.text = "巡检记录"
        binding.titleBar.button.setOnClickListener {
            finish()
        }
        binding.listView.adapter = object : BaseAdapter() {
            override fun getCount() = list.size

            override fun getItem(position: Int) = null

            override fun getItemId(position: Int) = 0L

            @SuppressLint("ViewHolder")
            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                val itemXunjianBinding =
                    ItemXunjianBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
                itemXunjianBinding.textView17.text = "房间号：" + list[position].fangjian
                itemXunjianBinding.textView18.text = "姓名：" + list[position].name
                itemXunjianBinding.textView20.text = "身体状况：" + list[position].qingkuang
                return itemXunjianBinding.root
            }
        }
    }
    data class ItemData(val fangjian: String, val name: String, val qingkuang: String)
}
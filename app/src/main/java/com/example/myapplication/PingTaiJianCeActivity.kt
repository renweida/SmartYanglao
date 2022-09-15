package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.myapplication.databinding.ActivityPingTaiJianCeBinding
import com.example.myapplication.databinding.ItemJianceBinding

class PingTaiJianCeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPingTaiJianCeBinding
    val list = mutableListOf(
        ItemData("26°C", "23", "32", "2", "80bpm", "80mmHg", "36.5°C", "中等", "一小时", "75kg"),
        ItemData("27°C", "45", "32", "2", "80bpm", "80mmHg", "36.5°C", "中等", "一小时", "75kg"),
        ItemData("25°C", "66", "32", "2", "80bpm", "80mmHg", "36.5°C", "中等", "一小时", "75kg"),
        ItemData("28°C", "33", "32", "2", "80bpm", "80mmHg", "36.5°C", "中等", "一小时", "75kg"),
        ItemData("23°C", "87", "32", "2", "80bpm", "80mmHg", "36.5°C", "中等", "一小时", "75kg"),
        ItemData("24°C", "55", "32", "2", "80bpm", "80mmHg", "36.5°C", "中等", "一小时", "75kg")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPingTaiJianCeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.titleBar.textView.text = "平台检测"
        binding.titleBar.button.setOnClickListener {
            finish()
        }
        binding.listView.adapter = object : BaseAdapter() {
            override fun getCount() = list.size

            override fun getItem(position: Int) = null

            override fun getItemId(position: Int) = 0L

            @SuppressLint("ViewHolder")
            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                val itemJianceBinding =
                    ItemJianceBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
                itemJianceBinding.textView18.text = "温度：" + list[position].wendu
                itemJianceBinding.textView20.text = "湿度：" + list[position].shidu
                itemJianceBinding.textView19.text = "二氧化碳浓度：" + list[position].co2
                itemJianceBinding.textView21.text = "PM2.5浓度：" + list[position].pm
                itemJianceBinding.textView23.text = "心率：" + list[position].xinlv
                itemJianceBinding.textView24.text = "血压：" + list[position].xueya
                itemJianceBinding.textView25.text = "体温：" + list[position].tiwen
                itemJianceBinding.textView26.text = "运动量：" + list[position].yundongliang
                itemJianceBinding.textView27.text = "户外活动时间：" + list[position].huwaihuadong
                itemJianceBinding.textView28.text = "体重：" + list[position].tizhong
                return itemJianceBinding.root
            }
        }
    }

    data class ItemData(
        val wendu: String, val shidu: String, val co2: String, val pm: String,
        val xinlv: String, val xueya: String, val tiwen: String, val yundongliang: String,
        val huwaihuadong: String, val tizhong: String
    )
}
package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import com.example.myapplication.bean.Yly
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ItemBinding
import com.example.myapplication.databinding.TitleBarBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.titleBar.textView.text = "智慧养老"
        binding.titleBar.button.setOnClickListener {
            finish()
            Log.d("TAG", "onCreate: ")
        }
        val list = listOf(
            Yly(
                "颐养天年养老院", R.drawable.img1, "空调、独卫、吹风机", "智能管家、一对一护理",
                "颐养天年养老院以信息化技术为核心，采用先进的计算机技术、通信技术、无线传输技术、控制技术，为老人提供一个安全、便捷、高效、舒适的养老综合服务"
            ),
            Yly(
                "老顽童养老院", R.drawable.img2, "空调、独卫、吹风机、淋浴", "智能管家",
                "老顽童养老院以信息化技术为核心，采用先进的计算机技术、通信技术、无线传输技术、控制技术，为老人提供一个安全、便捷、高效、舒适的养老综合服务"
            ),
            Yly(
                "夕阳红养老院", R.drawable.img3, "空调、独卫、吹风机、洗衣机", "智能管家、一对一护理、定期聚会",
                "夕阳红养老院以信息化技术为核心，采用先进的计算机技术、通信技术、无线传输技术、控制技术，为老人提供一个安全、便捷、高效、舒适的养老综合服务"
            )
        )
        binding.listView.adapter = object : BaseAdapter() {
            override fun getCount() = 3

            override fun getItem(position: Int) = null

            override fun getItemId(position: Int) = 0L

            @SuppressLint("ViewHolder", "SetTextI18n")
            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                val itemBinding =
                    ItemBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
                itemBinding.textView2.text = list[position].name
                itemBinding.textView3.text = "服务设施：" + list[position].shebei
                itemBinding.textView4.text = "服务体系：" + list[position].fuwu
                itemBinding.imageView.setBackgroundResource(list[position].tupian)
                return itemBinding.root
            }
        }
        binding.listView.setOnItemClickListener { _, _, position, _ ->
            startActivity(Intent(this, DetailActivity::class.java).putExtras(Bundle().apply {
                putString("name", list[position].name)
                putString("fuwu", list[position].fuwu)
                putString("shebei", list[position].shebei)
                putString("xinxi", list[position].xinxi)
                putInt("tupian", list[position].tupian)
            }))
        }
        binding.button6.setOnClickListener {
            startActivity(Intent(this, HealthEvalActivity::class.java))
        }
        binding.button7.setOnClickListener {
            startActivity(Intent(this, PingTaiJianCeActivity::class.java))
        }
        binding.button3.setOnClickListener {
            startActivity(Intent(this, XunJianJiLuActivity::class.java))
        }
        binding.button4.setOnClickListener {
            startActivity(Intent(this, CanYinJiLuActivity::class.java))
        }
        binding.button5.setOnClickListener {
            startActivity(Intent(this, JiZhongJianCeActivity::class.java))
        }
    }
}
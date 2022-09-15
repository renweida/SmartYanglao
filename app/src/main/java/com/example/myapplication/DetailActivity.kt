package com.example.myapplication

import android.annotation.SuppressLint
import android.icu.text.SymbolTable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import com.example.myapplication.databinding.ActivityDetailBinding
import com.example.myapplication.databinding.ItemCommentBinding
import java.text.SimpleDateFormat

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    var list = mutableListOf(CommentData("这是评论内容", "这是评论时间"))
    val myBaseAdapter = MyBaseAdapter()

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        val bundle = intent.extras!!
        binding.titleBar.textView.text = "养老院详情"
        binding.titleBar.button.setOnClickListener {
            finish()
        }
        binding.imageView2.setBackgroundResource(bundle.getInt("tupian"))
        binding.textView5.text = "养老院名称：" + bundle.getString("name")
        binding.textView6.text = "设备设施：" + bundle.getString("shebei")
        binding.textView7.text = "服务体系：" + bundle.getString("fuwu")
        binding.textView9.text = "简介：" + bundle.getString("xinxi")
        binding.listView.adapter = myBaseAdapter
        binding.buttonCommit.setOnClickListener {
            val time = SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(System.currentTimeMillis())
            val content = binding.editText.text.toString()
            if (content == "") {
                Toast.makeText(this, "内容不能为空", Toast.LENGTH_SHORT).show()
            } else {
                list.add(CommentData(content, time))
                Toast.makeText(this, "评论成功", Toast.LENGTH_SHORT).show()
                binding.editText.setText("")
                myBaseAdapter.notifyDataSetChanged()
            }
        }
    }

    inner class MyBaseAdapter : BaseAdapter() {
        override fun getCount() = list.size

        override fun getItem(position: Int) = null

        override fun getItemId(position: Int) = 0L

        @SuppressLint("ViewHolder")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val itemCommentBinding =
                ItemCommentBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
            itemCommentBinding.textView10.text = list[position].content
            itemCommentBinding.textView11.text = list[position].date
            return itemCommentBinding.root
        }

    }

    data class CommentData(val content: String, val date: String)

}
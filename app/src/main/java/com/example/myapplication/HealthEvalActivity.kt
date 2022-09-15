package com.example.myapplication

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.databinding.ActivityHealthEvalBinding

class HealthEvalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHealthEvalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHealthEvalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.titleBar.textView.text = "健康评估"
        binding.titleBar.button.setOnClickListener {
            finish()
        }
        binding.buttonCommit.setOnClickListener {
            if (binding.editText.text.toString() == "" || binding.editText2.text.toString() == "" ||
                binding.editText3.text.toString() == ""
            ) {
                Toast.makeText(this, "内容不能为空", Toast.LENGTH_SHORT).show()
            } else {
                AlertDialog.Builder(this).apply {
                    setTitle("服务费用")
                    setMessage("总计98元\n\n是否支付？")
                    setCancelable(false)
                    setNegativeButton("支付"){_, _ ->
                        Toast.makeText(this@HealthEvalActivity, "支付成功", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                    setPositiveButton("取消", null)
                    show()
                }
            }
        }
    }
}
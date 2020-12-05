package com.ckh.jim.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ckh.jim.databinding.ActivityMainBinding

// 老陈爬
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val wu = "给爷爬"
        binding.tvText.text = wu
        val pa = "在爬了"

        binding.btnFight.setOnClickListener {
            binding.tvText.text = if (binding.tvText.text == wu) {
                 pa
            } else {
                 wu
            }

        }

        binding.imginter.setOnClickListener {
            val intent = Intent(this, PaActivity::class.java)
            startActivity(intent)
        }

        binding.btnBlog.setOnClickListener {
            val intent = Intent(this, MyBlogActivity::class.java)
            startActivity(intent)
        }

    }
}
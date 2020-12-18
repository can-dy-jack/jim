package com.ckh.jim.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ckh.jim.StatusbarColorUtils
import com.ckh.jim.databinding.ActivityMainBinding

// 老陈爬
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val wu = "右边按钮\n打开博客"
        binding.tvText.text = wu
        val pa = "左边按钮打开\n仿制哔哩哔哩"

        StatusbarColorUtils.setStatusBarDarkIcon(this, false)

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
        // 设置循环播放次数，0 为不循环，-1 为一直循环，其他的如 3 为循环 3 次
        binding.lottieAnimationView.repeatCount = -1
        // 开始播放动画
        binding.lottieAnimationView.playAnimation()

        binding.imginter.repeatCount = -1
        binding.imginter.playAnimation()
    }
}
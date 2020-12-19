package com.ckh.jim.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.core.view.GravityCompat
import com.ckh.jim.StatusbarColorUtils
import com.ckh.jim.databinding.ActivityMainBinding
import com.ckh.jim.util.openUrlByBrowser
import com.ckh.jim.util.openUrlByWebActivity

// 老陈爬
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    /**
     * activity
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //StatusbarColorUtils.setStatusBarDarkIcon(this, false)
        // 加载视图
        initView()
    }


    private  fun initView() {
        binding.apply {
            imginter.setOnClickListener {
                val intent = Intent(this@MainActivity, PaActivity::class.java)
                startActivity(intent)
            }

            btnBlog.setOnClickListener {
                val intent = Intent(this@MainActivity, MyBlogActivity::class.java)
                startActivity(intent)
            }
            // 设置循环播放次数，0 为不循环，-1 为一直循环，其他的如 3 为循环 3 次
            lottieAnimationView.repeatCount = -1
            // 开始播放动画
            lottieAnimationView.playAnimation()

            //左边
            imginter.repeatCount = -1
            imginter.playAnimation()

            //右边
            btnBlog.repeatCount = -1
            btnBlog.playAnimation()
            //顶部
            imgMainTop.repeatCount = -1
            imgMainTop.playAnimation()

            ivMenu.repeatCount = -1
            ivMenu.playAnimation()

            imgRight.repeatCount = -1
            imgRight.playAnimation()
//            imgMainTop.setOnClickListener {
//                openUrlByBrowser(this@MainActivity, "https://kartjim.top")
//            }

            ivMenu.setOnClickListener {
                drawerLayout.openDrawer(GravityCompat.START)
            }

            includeMainMenu.tvKartjim.setOnClickListener{
//                openUrlByBrowser(this@MainActivity, "https://kartjim.top")
                openUrlByWebActivity(this@MainActivity, "https://kartjim.top")
            }
            includeMainMenu.tvCandyjack.setOnClickListener{
                openUrlByWebActivity(this@MainActivity, "https://github.com/can-dy-jack/jim")
            }
            includeMainMenu.tvMoriafly.setOnClickListener{
                openUrlByWebActivity(this@MainActivity, "https://moriafly.xyz")
            }
            includeMainMenu.tvDirror.setOnClickListener{
                openUrlByWebActivity(this@MainActivity, "https://github.com/Moriafly/dirror-music")
            }
        }
    }
}
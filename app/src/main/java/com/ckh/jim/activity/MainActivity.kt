package com.ckh.jim.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.security.FileIntegrityManager
import androidx.core.view.GravityCompat
import androidx.viewpager2.widget.ViewPager2
import com.ckh.jim.MagicHttp
import com.ckh.jim.adapter.SentenceAdapter
import com.ckh.jim.databinding.ActivityMainBinding
import com.ckh.jim.util.openDsoMusic
import com.ckh.jim.util.openUrlByWebActivity
import com.ckh.jim.util.runOnMainThread
import kotlinx.android.synthetic.main.activity_main.*


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

        getSentence()

        binding.apply {
            includeSentence.root.setOnClickListener {
                getSentence()
            }
            imginter.setOnClickListener {
                val intent = Intent(this@MainActivity, PaActivity::class.java)
                startActivity(intent)
            }
            //左边
            imginter.repeatCount = -1
            imginter.playAnimation()

            ivMenu.repeatCount = -1
            ivMenu.playAnimation()

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
//                val url = "https://v1.hitokoto.cn/?encode=text"
//                MagicHttp.OkHttpManager().newGet(url, {
//                    toast(it)
//                }, {
//
//                })
                //toast("util.TopLevelFunction.kt")
                openDsoMusic(this@MainActivity) {
                    openUrlByWebActivity(this@MainActivity,"https://github.com/Moriafly/dirror-music/releases")
                }
            }
            includeMainMenu.cvBottom.setOnClickListener{
                finish()
            }
            includeMainMenu.cvBlog.setOnClickListener{
                val intent = Intent(this@MainActivity,MyBlogActivity::class.java)
                startActivity(intent)
            }
            //打开 sign in
            includeMainMenu.tvSign.setOnClickListener{
                val intent = Intent(this@MainActivity,SignInActivity::class.java)
                startActivity(intent)
            }
        }
    }
    /**
     * 获取一个句子到字符串数组中
     */
    fun getSentence() {
        MagicHttp.OkHttpManager().newGet("https://v1.hitokoto.cn/?encode=text",{
            runOnMainThread {
                binding.includeSentence.tvSentence.text = it
            }
        },{

        })
    }
}
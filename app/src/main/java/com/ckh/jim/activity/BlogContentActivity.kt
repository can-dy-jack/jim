package com.ckh.jim.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ckh.jim.MagicHttp
import com.ckh.jim.databinding.ActivityBlogContentBinding
import com.ckh.jim.util.runOnMainThread

class BlogContentActivity : AppCompatActivity() {

    companion object {
        const val DEFAULT_WEBSITE = "https://moriafly.xyz/jim"
        const val EXTRA_STRING_URL = "string_url"
    }

    private lateinit var binding: ActivityBlogContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlogContentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        initListener()
    }

    private fun initView() {
        val url = intent.getStringExtra(EXTRA_STRING_URL)
        binding.apply {
            tvTitle.text = url

            val mdUrl = "${DEFAULT_WEBSITE}/source/${url}"

            MagicHttp.OkHttpManager().newGet(mdUrl, {
                runOnMainThread {
                    binding.markdownWebView.setText(it)
                }
            }, {

            })
        }
    }

    private fun initListener() {
        binding.apply {
            ivBack.setOnClickListener {
                finish()
            }
        }
    }
}
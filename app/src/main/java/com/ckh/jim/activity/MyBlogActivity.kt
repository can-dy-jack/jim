package com.ckh.jim.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ckh.jim.MagicHttp
import com.ckh.jim.R
import com.ckh.jim.adapter.BlogAdapter
import com.ckh.jim.adapter.BlogData
import com.ckh.jim.util.runOnMainThread
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_my_blog.*

class MyBlogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_blog)
        // json 配置文件
        val url = "${BlogContentActivity.DEFAULT_WEBSITE}/android.json"
        // "https://www.wanandroid.com/article/list/0/json"

        MagicHttp.OkHttpManager().newGet(

            url, {
                val data = Gson().fromJson(it, BlogData::class.java).data
                runOnMainThread {
                    rvBlog.layoutManager = LinearLayoutManager(this)
                    rvBlog.adapter = BlogAdapter(data)
                }
            }, {

            }
        )

        btnLog2.setOnClickListener {
            val intent = Intent(this, FlActivity::class.java)
            startActivity(intent)
        }
    }

}
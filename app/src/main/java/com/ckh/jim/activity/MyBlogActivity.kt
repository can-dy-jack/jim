package com.ckh.jim.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.LinearLayoutManager
import com.ckh.jim.MagicHttp
import com.ckh.jim.R
import com.ckh.jim.adapter.BlogAdapter
import com.ckh.jim.adapter.BlogData
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_my_blog.*

class MyBlogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_blog)

        MagicHttp.OkHttpManager().newGet(
            "https://www.wanandroid.com/article/list/0/json", {
                val datas = Gson().fromJson(it, BlogData::class.java).data.datas
                runOnUiThread {
                    rvBlog.layoutManager = LinearLayoutManager(this)
                    rvBlog.adapter = BlogAdapter(datas)
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

// 运行在主线程，更新 UI
fun runOnMainThread(runnable: Runnable) {
    Handler(Looper.getMainLooper()).post(runnable)
}

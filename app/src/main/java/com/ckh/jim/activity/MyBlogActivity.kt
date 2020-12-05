package com.ckh.jim.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ckh.jim.R
import com.ckh.jim.adapter.BlogAdapter
import com.ckh.jim.adapter.BlogData
import kotlinx.android.synthetic.main.activity_my_blog.*

class MyBlogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_blog)

        val list = ArrayList<BlogData>()
        for (i in 0..100) {
            list.add(BlogData(i.toString()))
        }

        rvBlog.layoutManager = LinearLayoutManager(this)
        rvBlog.adapter = BlogAdapter(list)

        btnLog2.setOnClickListener {
            val intent = Intent(this, FlActivity::class.java)
            startActivity(intent)
        }
    }

}
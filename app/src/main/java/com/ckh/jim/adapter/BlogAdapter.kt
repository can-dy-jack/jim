package com.ckh.jim.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.ckh.jim.R
import com.ckh.jim.activity.BlogContentActivity

class BlogAdapter(private val blogList: ArrayList<BlogItemData>) :
    RecyclerView.Adapter<BlogAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvTitle: TextView = view.findViewById(R.id.tvTitle)

        val clBlogItem: ConstraintLayout = view.findViewById(R.id.clBlogItem)
        val tvIntro: TextView = view.findViewById(R.id.tvIntro)
        // val tvTrackCount: TextView = view.findViewById(R.id.tvTrackCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_blog, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val blog = blogList[position]
        holder.tvTitle.text = blog.url.replace(".md", "")
        holder.clBlogItem.setOnClickListener {
            val intent = Intent(holder.itemView.context, BlogContentActivity::class.java)
            intent.putExtra(BlogContentActivity.EXTRA_STRING_URL, blogList[position].url)
            holder.itemView.context.startActivity(intent)
        }
        holder.tvIntro.text = blog.intro?: ""
    }

    override fun getItemCount(): Int {
        return blogList.size
    }

}

data class BlogData(
    val data: ArrayList<BlogItemData>
)

data class BlogItemData(
    val url: String,
    val intro: String?
)
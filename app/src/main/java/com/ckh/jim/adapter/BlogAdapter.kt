package com.ckh.jim.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ckh.jim.R


class BlogAdapter(private val blogList: ArrayList<BlogData>) :
    RecyclerView.Adapter<BlogAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        // val tvTrackCount: TextView = view.findViewById(R.id.tvTrackCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_blog, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = blogList[position].title
    }

    override fun getItemCount(): Int {
        return blogList.size
    }

}

data class BlogData(
    val title : String
        )
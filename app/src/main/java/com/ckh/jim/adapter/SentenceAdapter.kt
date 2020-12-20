package com.ckh.jim.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ckh.jim.R


class SentenceAdapter(private val sentenceList: ArrayList<String>) :
    RecyclerView.Adapter<SentenceAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvSentence: TextView = view.findViewById(R.id.tvSentence)
        // val tvTrackCount: TextView = view.findViewById(R.id.tvTrackCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle_sentence, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvSentence.text = sentenceList[position]
    }

    override fun getItemCount(): Int {
        return sentenceList.size
    }

    fun addItem(sentence: String) {
        sentenceList.add(sentence)
    }

}
package com.example.coroutines.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutines.R
import com.example.coroutines.model.Model

class CustomAdapter: RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    var dataList = mutableListOf<Model>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<Model>) {
        this.dataList = data.toMutableList()
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val postTitleTextView: TextView = view.findViewById(R.id.postTitle_TV)
        val postBodyTextView: TextView = view.findViewById(R.id.post_Msg_TV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.postTitleTextView.text = dataList[position].postTitle
        holder.postBodyTextView.text = dataList[position].postBody
    }
}
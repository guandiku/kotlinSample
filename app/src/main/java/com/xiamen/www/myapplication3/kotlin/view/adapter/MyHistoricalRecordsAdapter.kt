package com.xiamen.www.myapplication3.kotlin.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.xiamen.www.myapplication3.R

import com.xiamen.www.myapplication3.kotlin.module.bean.HistoricalRecordsBean
import org.jetbrains.anko.find
import org.jetbrains.anko.imageResource

/**
 * Created by White on 2018/3/13.
 *
 */


class MyHistoricalRecordsAdapter(private var context: Context, private var list: List<HistoricalRecordsBean>) : RecyclerView.Adapter<MyHistoricalRecordsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_person_center_play_history, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.textView = view.find(R.id.tv_item_play_history)
        viewHolder.imageView = view.find(R.id.iv_item_play_history)
        viewHolder.textViewProgress = view.find(R.id.tv_item_play_history_progress)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bean = list[position]
        holder.textView.text = bean.text
        holder.imageView.imageResource = bean.image
        holder.textViewProgress.text = bean.textProgress
    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        lateinit var imageView: ImageView
        lateinit var textView: TextView
        lateinit var textViewProgress: TextView
    }


}


package com.xiamen.www.myapplication3.kotlin.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.xiamen.www.myapplication3.R
import com.xiamen.www.myapplication3.kotlin.module.bean.FilmClassificationBean
import org.jetbrains.anko.find
import org.jetbrains.anko.imageResource

/**
 * Created by White on 2018/3/15.
 */
class FilmClassificationAdapter(
        private var context: Context,
        private var list:List<FilmClassificationBean>): RecyclerView.Adapter<FilmClassificationAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder{
        val view=LayoutInflater.from(context).inflate(R.layout.item_fragment_film,parent,false)
        val viewHolder = ViewHolder(view)
        viewHolder.imageView = view.find(R.id.iv_item_fragment_film_picture)
        viewHolder.textView = view.find(R.id.tv_item_fragment_film_title)
        viewHolder.textViewContent = view.find(R.id.tv_item_fragment_film_content)
        return viewHolder
    }

    override fun getItemCount(): Int = if (list==null) 0 else list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val bean=list[position]
        holder.imageView.imageResource=bean.imageUrl
        holder.textView.text=bean.title
        holder.textViewContent.text=bean.content
    }


    class ViewHolder(item:View) :RecyclerView.ViewHolder(item){
        lateinit var imageView: ImageView
        lateinit var textView: TextView
        lateinit var textViewContent: TextView
    }

}
package com.xiamen.www.myapplication3.kotlin.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.xiamen.www.myapplication3.R
import com.xiamen.www.myapplication3.kotlin.module.bean.FilmClassificationBean
import org.jetbrains.anko.find
import org.jetbrains.anko.imageResource

/**
 * Created by White on 2018/3/15.
 */
class HotInformationAdapter(private var context: Context, private var list: List<FilmClassificationBean>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        val TYPE_ONE = 1
        val TYPE_TWO = 2
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val bean = list[position]
        if (holder is FirstHolder) {
            if (position == 0) {
                holder.imageView.imageResource = bean.imageUrl
                holder.textView.text = bean.title
                holder.textContent.text = bean.content
            }

        } else if (holder is SecondHolder) {
            if (position == 1) {
                holder.imageView.imageResource = bean.imageUrl
                holder.textView.text = bean.title
                holder.textContent.text = bean.content
                holder.imageView2.imageResource = list[2].imageUrl
                holder.textView2.text = list[2].title
                holder.textContent2.text = list[2].content
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_ONE) {
            FirstHolder(getView(R.layout.item_hot_information_type_one))
        } else {
            SecondHolder(getView(R.layout.item_hot_information_type_two))
        }
    }

    override fun getItemCount(): Int = list.size - 1

    /**
     * 用来引入布局的方法
     */
    private fun getView(view: Int): View {
        return View.inflate(context, view, null)
    }


    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TYPE_ONE
            1 -> TYPE_TWO
            else -> TYPE_TWO
        }
    }


    private class FirstHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.find(R.id.iv_item_fragment_film_image)
        var textView: TextView = itemView.find(R.id.tv_item_fragment_film_title)
        var textContent: TextView = itemView.findViewById(R.id.tv_item_fragment_film_content)
    }


    private class SecondHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.find(R.id.iv_item_fragment_film_picture)
        var textView: TextView = itemView.find(R.id.tv_item_fragment_film_title)
        var textContent: TextView = itemView.findViewById(R.id.tv_item_fragment_film_content)

        var imageView2: ImageView = itemView.find(R.id.iv_item_fragment_film_picture2)
        var textView2: TextView = itemView.find(R.id.tv_item_fragment_film_title2)
        var textContent2: TextView = itemView.findViewById(R.id.tv_item_fragment_film_content2)
    }

}
package com.example.elegentrecyclerviewdemo.binder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.elegentrecyclerviewdemo.R
import com.example.elegentrecyclerviewdemo.adapter.ZRvAdapter

/**
 * @class
 * @author YYQF
 * @data 2021/8/19
 * @description
 **/
class CategoryContainerBinder(private val data: List<CategoryItemBinder>) : BaseBinder() {
    override fun layoutId(): Int = R.layout.item_catagory_container

    override fun onBind(itemView: View) {
        val rv : RecyclerView = itemView.findViewById(R.id.container_rv)
        val adapter = ZRvAdapter().apply {
            notifyAdapterChanged(data)
        }
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(itemView.context)
    }

    override fun areContentsTheSame(binder: BaseBinder): Boolean {
        if (data.size != (binder as CategoryContainerBinder).data.size ) return false
        repeat(data.size){
            if (data[it].title != binder.data[it].title){
                return false
            }
        }
        return true
    }

}

class CategoryItemBinder(val title: String) : BaseBinder(){

    override fun areContentsTheSame(binder: BaseBinder): Boolean {
        return (binder as CategoryItemBinder).title == title
    }

    override fun layoutId() = R.layout.item_category_child

    override fun onBind(itemView: View) {
        itemView.findViewById<TextView>(R.id.item_child_title).text = title
    }
}
package com.example.elegentrecyclerviewdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.elegentrecyclerviewdemo.binder.BaseBinder
import com.example.elegentrecyclerviewdemo.callback.DiffItemCallback
import com.example.elegentrecyclerviewdemo.helper.Movable


/**
 * @class
 * @author YYQF
 * @data 2021/9/16
 * @description
 **/
class ZRvAdapter : RecyclerView.Adapter<ZRvAdapter.DataBindingViewHolder>(), Movable {

    private val mAsyncListChange by lazy { AsyncListDiffer(this, DiffItemCallback<BaseBinder>()) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder {
        return DataBindingViewHolder(LayoutInflater.from(parent.context)
            .inflate(viewType,parent,false))
    }

    override fun onBindViewHolder(holder: DataBindingViewHolder, position: Int) {
        holder.bindData(mAsyncListChange.currentList[position])
    }

    class DataBindingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(binder: BaseBinder){
            binder.onBind(itemView)
        }
    }

    fun notifyAdapterChanged(binders: List<BaseBinder>){
        mAsyncListChange.submitList(binders)
    }

    override fun getItemViewType(position: Int): Int {
        return mAsyncListChange.currentList[position].layoutId()
    }

    override fun getItemCount(): Int = mAsyncListChange.currentList.size

    override fun onItemDragVertical(fromPos: Int, toPos: Int) {
        val newList = mutableListOf<BaseBinder>()
        newList.addAll(mAsyncListChange.currentList)
        val temp = newList[fromPos]
        newList[fromPos] = newList[toPos]
        newList[toPos] = temp
        mAsyncListChange.submitList(newList)
    }

    override fun onItemRemove(pos: Int) {
        val newList = mutableListOf<BaseBinder>()
        newList.addAll(mAsyncListChange.currentList)
        newList.removeAt(pos)
        mAsyncListChange.submitList(newList)
    }

}
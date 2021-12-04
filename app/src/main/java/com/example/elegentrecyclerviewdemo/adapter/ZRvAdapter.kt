package com.example.elegentrecyclerviewdemo.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.elegentrecyclerviewdemo.binder.BaseBinder
import com.example.elegentrecyclerviewdemo.callback.DiffItemCallback


/**
 * @class
 * @author YYQF
 * @data 2021/9/16
 * @description
 **/
class ZRvAdapter : RecyclerView.Adapter<ZRvAdapter.DataBindingViewHolder>(){

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
        Log.d("TAG","(DataBindingAdapter.kt:42)->${binders.size}")
        mAsyncListChange.submitList(binders)
    }

    override fun getItemViewType(position: Int): Int {
        return mAsyncListChange.currentList[position].layoutId()
    }

    override fun getItemCount(): Int = mAsyncListChange.currentList.size

}
package com.example.elegentrecyclerviewdemo.callback

import androidx.recyclerview.widget.DiffUtil
import com.example.elegentrecyclerviewdemo.binder.BaseBinder

/**
 * @class
 * @author YYQF
 * @data 2021/8/19
 * @description
 **/
class DiffItemCallback<B: BaseBinder> : DiffUtil.ItemCallback<B>() {
    override fun areItemsTheSame(oldItem: B, newItem: B): Boolean {
        return oldItem.areItemsTheSame(newItem)
    }

    override fun areContentsTheSame(oldItem: B, newItem: B): Boolean {
        return oldItem.areContentsTheSame(newItem)
    }
}
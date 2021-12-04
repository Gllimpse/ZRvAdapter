package com.example.elegentrecyclerviewdemo.extentions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.elegentrecyclerviewdemo.adapter.ZRvAdapter

/**
 * @class
 * @author YYQF
 * @data 2021/8/18
 * @description
 **/

fun ViewGroup.inflateDataBinding(@LayoutRes resId: Int): ViewDataBinding{
    return DataBindingUtil.inflate(LayoutInflater.from(this.context),resId,this,false)
}

fun createBindingAdapter(recyclerView: RecyclerView,layoutManager: RecyclerView.LayoutManager): ZRvAdapter {
    recyclerView.layoutManager = layoutManager
    val mAdapter = ZRvAdapter()
    recyclerView.adapter = mAdapter
    // 处理RecyclerView的触发回调
    recyclerView.addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener{
        override fun onViewAttachedToWindow(v: View?) {
        }

        override fun onViewDetachedFromWindow(v: View?) {
            mAdapter.onDetachedFromRecyclerView(recyclerView)
        }
    })
    return mAdapter
}

fun Context.showToast(msg: String){
    Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
}
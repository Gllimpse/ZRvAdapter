package com.example.elegentrecyclerviewdemo.binder

import android.view.View

/**
 * @class
 * @author YYQF
 * @data 2021/8/18
 * @description
 **/
abstract class BaseBinder {

    open fun onBind(itemView: View){}

    abstract fun areContentsTheSame(binder: BaseBinder): Boolean

    abstract fun areItemsTheSame(binder: BaseBinder): Boolean


    abstract fun layoutId(): Int
}
package com.example.elegentrecyclerviewdemo.binder

import android.view.View

/**
 * @class
 * @author YYQF
 * @data 2021/8/18
 * @description
 **/
abstract class BaseBinder {
    open val itemId : Int? = null

    open fun onBind(itemView: View){}

    abstract fun areContentsTheSame(binder: BaseBinder): Boolean

    abstract fun layoutId(): Int
}
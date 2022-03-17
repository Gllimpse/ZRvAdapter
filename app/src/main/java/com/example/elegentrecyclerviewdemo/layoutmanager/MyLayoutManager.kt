package com.example.elegentrecyclerviewdemo.layoutmanager

import android.content.Context
import android.graphics.drawable.GradientDrawable
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * @class
 * @author GLimpse
 * @date 2022/3/17
 * @description
 **/
class MyLayoutManager(context: Context,
                      spanCount: Int,
                      orientation: Int = RecyclerView.VERTICAL,
                      reverse:Boolean = false) : GridLayoutManager(context, spanCount,orientation,reverse) {
}
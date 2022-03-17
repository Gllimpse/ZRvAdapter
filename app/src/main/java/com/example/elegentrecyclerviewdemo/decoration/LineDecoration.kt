package com.example.elegentrecyclerviewdemo.decoration

import android.graphics.*
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.elegentrecyclerviewdemo.R

/**
 * @class
 * @author GLimpse
 * @date 2022/3/17
 * @description
 **/
class LineDecoration : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.top = 24
        outRect.left = 200
        outRect.right = 50
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        val manger = parent.layoutManager!!
        val r = 26f
        var gap = 10f
        val path = Path()
        val paint = Paint().apply {
            color = ContextCompat.getColor(parent.context,R.color.item_decor_blue)
            strokeWidth = 8f
            //默认是？
            style = Paint.Style.STROKE
        }
        repeat(parent.childCount){
            val child = parent.getChildAt(it)
            val leftDecorationWidth = manger.getLeftDecorationWidth(child)
            val topDecorationWidth = manger.getTopDecorationHeight(child)
            with(path){
                if (it!=0) {
                    moveTo(leftDecorationWidth / 2f, child.top.toFloat())
                    lineTo(leftDecorationWidth / 2f, child.top + child.height / 2 - r - gap)
                }
                if (it!=parent.childCount-1) {
                    moveTo(leftDecorationWidth / 2f, child.top + child.height / 2 + r + gap)
                    lineTo(
                        leftDecorationWidth / 2f,
                        child.top.toFloat() + child.height + topDecorationWidth
                    )
                }
            }
            with(c){
                paint.style = Paint.Style.STROKE
                drawPath(path, paint)
                paint.style = Paint.Style.FILL
                drawCircle(leftDecorationWidth/2f,child.top.toFloat()+child.height/2,r,paint)
            }
        }

    }
}
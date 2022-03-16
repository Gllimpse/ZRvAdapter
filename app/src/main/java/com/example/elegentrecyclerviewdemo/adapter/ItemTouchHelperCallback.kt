package com.example.elegentrecyclerviewdemo.adapter

import android.annotation.SuppressLint
import android.graphics.Canvas
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.elegentrecyclerviewdemo.R
import kotlin.math.max
import kotlin.math.min

/**
 * @class
 * @author GLimpse
 * @date 2022/3/16
 * @description
 **/
@SuppressLint("LongLogTag")
class ItemTouchHelperCallback(val adapter: MovableAdapter) : ItemTouchHelper.Callback() {
    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val verticalFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
        val horizontalFlags = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        return makeMovementFlags(verticalFlags, horizontalFlags)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        viewHolder.itemView.findViewById<TextView>(R.id.item_child_title).elevation = 40f
        adapter.onItemDragVertical(viewHolder.adapterPosition, target.adapterPosition)
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

        adapter.onItemRemove(viewHolder.adapterPosition)
    }

    //是否允许长按上下拖动
    override fun isLongPressDragEnabled(): Boolean {
        return true
    }

    //返回删除Item的横向滑动 距离 阙值
    override fun getSwipeThreshold(viewHolder: RecyclerView.ViewHolder): Float {
        return Float.MAX_VALUE
    }

    //返回删除Item的横向滑动 速度 阙值
    override fun getSwipeEscapeVelocity(defaultValue: Float): Float {
        return Float.MAX_VALUE
    }
    var finalTransX = 0f
    var initTransX = 0f

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        val maxTransX = -300f
        if (dX == 0f){
            initTransX = viewHolder.itemView.translationX
        }
        if (isCurrentlyActive){
            viewHolder.itemView.translationX = min(max(initTransX+dX,maxTransX),0f)
            finalTransX = viewHolder.itemView.translationX
        }else{
            when{
                dX>0 -> viewHolder.itemView.translationX = 0f
                finalTransX > maxTransX -> viewHolder.itemView.translationX = dX
                else -> viewHolder.itemView.translationX = maxTransX
            }
        }
    }
}
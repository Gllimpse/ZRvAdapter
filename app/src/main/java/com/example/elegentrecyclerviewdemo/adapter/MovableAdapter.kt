package com.example.elegentrecyclerviewdemo.adapter

/**
 * @class
 * @author GLimpse
 * @date 2022/3/16
 * @description
 **/
interface MovableAdapter {
    fun onItemDragVertical(fromPos:Int,toPos:Int)
    fun onItemRemove(pos:Int)
}
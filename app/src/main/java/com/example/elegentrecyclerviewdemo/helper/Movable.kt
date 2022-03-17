package com.example.elegentrecyclerviewdemo.helper

/**
 * @class
 * @author GLimpse
 * @date 2022/3/16
 * @description
 **/
interface Movable {
    fun onItemDragVertical(fromPos:Int,toPos:Int)
    fun onItemRemove(pos:Int)
}
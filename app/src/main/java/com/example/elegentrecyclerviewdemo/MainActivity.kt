package com.example.elegentrecyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.elegentrecyclerviewdemo.adapter.ItemTouchHelperCallback
import com.example.elegentrecyclerviewdemo.adapter.ZRvAdapter
import com.example.elegentrecyclerviewdemo.binder.BaseBinder
import com.example.elegentrecyclerviewdemo.binder.CategoryContainerBinder
import com.example.elegentrecyclerviewdemo.binder.CategoryItemBinder
import com.example.elegentrecyclerviewdemo.extentions.createBindingAdapter

class MainActivity : AppCompatActivity(){
    private lateinit var rv: RecyclerView
    private lateinit var adapter: ZRvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.main_recycler)
        adapter = createBindingAdapter(rv,LinearLayoutManager(this))
        ItemTouchHelper(ItemTouchHelperCallback(adapter)).also { it.attachToRecyclerView(rv) }

        initData(adapter)
    }

    private fun initData(adapter: ZRvAdapter){
        adapter.notifyAdapterChanged(mutableListOf<BaseBinder>().apply {
            listOf("111", "222", "333", "444", "555", "666").map {
                add(CategoryItemBinder(it))
            }
        })
    }
}
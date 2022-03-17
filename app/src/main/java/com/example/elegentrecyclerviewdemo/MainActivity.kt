package com.example.elegentrecyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.*
import com.example.elegentrecyclerviewdemo.helper.ItemTouchHelperCallback
import com.example.elegentrecyclerviewdemo.adapter.ZRvAdapter
import com.example.elegentrecyclerviewdemo.binder.BaseBinder
import com.example.elegentrecyclerviewdemo.binder.CategoryContainerBinder
import com.example.elegentrecyclerviewdemo.binder.CategoryItemBinder
import com.example.elegentrecyclerviewdemo.decoration.LineDecoration
import com.example.elegentrecyclerviewdemo.extentions.createBindingAdapter

class MainActivity : AppCompatActivity(){
    private lateinit var rv: RecyclerView
    private lateinit var adapter: ZRvAdapter
    private lateinit var layoutManager: GridLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.main_recycler)
        layoutManager = GridLayoutManager(this,1).apply {
            spanSizeLookup = object : GridLayoutManager.SpanSizeLookup(){
                override fun getSpanSize(position: Int) = 1
            }
        }
        adapter = createBindingAdapter(rv,layoutManager)
        ItemTouchHelper(
            ItemTouchHelperCallback(adapter,
            supportLongPressDragArbitrary = false,
            supportHorizontalSwipe = true
        )
        ).also { it.attachToRecyclerView(rv) }
        rv.addItemDecoration(LineDecoration())
        initData(adapter)
    }

    private fun initData(adapter: ZRvAdapter){
        adapter.notifyAdapterChanged(mutableListOf<BaseBinder>().apply {
            listOf("111", "222").map {
                add(CategoryItemBinder(it))
            }
            add(CategoryContainerBinder(mutableListOf<CategoryItemBinder>().apply{
                listOf("111", "222", "333", "444",).map {
                    add(CategoryItemBinder(it))
                }
            }))
            listOf("111", "222").map {
                add(CategoryItemBinder(it))
            }
            add(CategoryContainerBinder(mutableListOf<CategoryItemBinder>().apply{
                listOf("111", "222", "333", "444",).map {
                    add(CategoryItemBinder(it))
                }
            }))
            listOf("111", "222").map {
                add(CategoryItemBinder(it))
            }
        })
    }
}
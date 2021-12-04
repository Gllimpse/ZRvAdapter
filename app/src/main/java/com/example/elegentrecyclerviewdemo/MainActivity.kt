package com.example.elegentrecyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

        initData(adapter)
    }

    private fun initData(adapter: ZRvAdapter){
        adapter.notifyAdapterChanged(mutableListOf<BaseBinder>().apply {
            add(CategoryContainerBinder(listOf("男装", "女装", "鞋靴", "内衣内饰", "箱包", "美妆护肤", "洗护", "腕表珠宝", "手机", "数码").map {
                CategoryItemBinder(it)
            }))
        })
    }
}
package com.example.convinassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        //here set layout of our recyclerView as linear
        recyclerView.layoutManager = LinearLayoutManager(this)
        //now adding need adapter and ViewHolder for recycler view rv

        val items = fetchData()
        //set adaptor
        val adaptor = RVAdaptor(items)
        recyclerView.adapter = adaptor

        //here need to add swipe refresh layout

        val swipe : SwipeRefreshLayout = findViewById(R.id.swipeRefreshLayout)
        swipe.setOnRefreshListener{
            //update data
            items.addAll(updateData())
            //notify adapter about data set changed
            adaptor.notifyDataSetChanged()
            //stop refreshing when task completed
            swipe.isRefreshing = false
        }

    }

    //we will fetch data using
    fun fetchData() : ArrayList<String>{
         val list = ArrayList<String>()
        for (i in 0 until 20){
            list.add("item $i")
        }
        return list
    }


//here now updated data till 30
//till now recyclerView is 20

fun updateData() : ArrayList<String>{
    val item = ArrayList<String>()
    for (i in 20 until 30) {
        item.add("item $i")
    }
    return item
}
}

package com.example.convinassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class RVAdaptor(private val  item:ArrayList<String>): RecyclerView.Adapter<RVAdaptor.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
      //use textView view
        val textView : TextView = itemView.findViewById(R.id.text)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //creates a viewHolder every time its needed
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv,parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //bind data with the viewHolder
        //we need an array of string
        holder.textView.text = item[position]
    }

    override fun getItemCount(): Int {
        //return size of item
        return item.size
    }

}
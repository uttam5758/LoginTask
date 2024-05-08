package com.example.myassignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mytask.R

class RecyclerViewAdapter(var nameList: ArrayList<String>,
                          var descriptionList: ArrayList<String>) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {

    class RecyclerViewHolder(view : View) : RecyclerView.ViewHolder(view){
        //bind views from layout file
        var title : TextView = view.findViewById(R.id.title)
        var description: TextView = view.findViewById(R.id.description)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        // when users opens activity this method links layout file to our activity
        var view : View = LayoutInflater.from(parent.context).inflate(R.layout.samplerecycleview,parent,false)
        return RecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return nameList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.title.text =  nameList[position]
        holder.description.text =  descriptionList[position]
    }
}
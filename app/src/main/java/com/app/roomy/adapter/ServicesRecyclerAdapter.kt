package com.app.roomy.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.roomy.R

class ServicesRecyclerAdapter : RecyclerView.Adapter<ServicesRecyclerAdapter.ServicesRecyclerViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesRecyclerViewHolder
    {
        return ServicesRecyclerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.services_item_layout,parent,false))
    }

    override fun getItemCount(): Int
    {
       return 20;
    }

    override fun onBindViewHolder(holder: ServicesRecyclerViewHolder, position: Int) {

    }


    class  ServicesRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {

    }
}
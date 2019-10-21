package com.app.roomy.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.roomy.R

class DemandsRecyclerAdapter: RecyclerView.Adapter<DemandsRecyclerAdapter.DemandsRecyclerViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DemandsRecyclerViewHolder
    {
       return DemandsRecyclerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.demands_item_layout,null,false))
    }

    override fun getItemCount(): Int {
      return 20
    }

    override fun onBindViewHolder(holder: DemandsRecyclerViewHolder, position: Int)
    {

    }

    class DemandsRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {

    }
}
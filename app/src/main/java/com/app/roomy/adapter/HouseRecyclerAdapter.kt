package com.app.roomy.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.roomy.R
import com.app.roomy.model.HouseModel
import com.app.roomy.view.activity.DetailActivity

class HouseRecyclerAdapter : RecyclerView.Adapter<HouseRecyclerAdapter.HouseRecyclerViewHolder>()
{

   private val houseList = listOf(HouseModel())

    override fun getItemCount(): Int
    {
        return 20;
        //return houseList.size
    }

    public fun addNewItem()
    {
        this.notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: HouseRecyclerViewHolder, position: Int)
    {



        holder.itemView.setOnClickListener {
            it.context.startActivity(Intent(it.context,DetailActivity::class.java))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HouseRecyclerViewHolder
    {
        return HouseRecyclerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.house_item_layout,parent,false))
    }


    class HouseRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {

    }
}
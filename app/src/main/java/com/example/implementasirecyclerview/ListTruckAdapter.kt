package com.example.implementasirecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListTruckAdapter(private val listTruk:ArrayList<Truck>) : RecyclerView.Adapter<ListTruckAdapter.ListViewHolder>(){

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto :ImageView = itemView.findViewById(R.id.img_item_photo)
        val nameTruck : TextView = itemView.findViewById(R.id.tv_item_name)
        val descTruck: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list_truck, parent,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listTruk[position]
        holder.imgPhoto.setImageResource(photo)
        holder.nameTruck.text = name
        holder.descTruck.text = description
        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context, "Kamu memilih" + listTruk[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
        }
    }

}
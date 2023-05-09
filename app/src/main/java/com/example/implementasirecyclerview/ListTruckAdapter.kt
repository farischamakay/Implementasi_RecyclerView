package com.example.implementasirecyclerview
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListTruckAdapter(private val listTruk:ArrayList<Truck>) : RecyclerView.Adapter<ListTruckAdapter.ListViewHolder>(){

    private lateinit var onItemClickCallback : OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list_truck, parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listTruk[position]
        holder.imgPhoto.setImageResource(photo)
        holder.nameTruck.text = name
        holder.descTruck.text = description
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listTruk[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int =
        listTruk.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto :ImageView = itemView.findViewById(R.id.img_item_photo)
        val nameTruck : TextView = itemView.findViewById(R.id.tv_item_name)
        val descTruck: TextView = itemView.findViewById(R.id.tv_item_description)
    }


    interface OnItemClickCallback{
        fun onItemClicked(data : Truck)
    }

}
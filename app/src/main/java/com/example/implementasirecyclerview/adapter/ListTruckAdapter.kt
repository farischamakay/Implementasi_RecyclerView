package com.example.implementasirecyclerview.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.implementasirecyclerview.data.Truck
import com.example.implementasirecyclerview.databinding.ItemListTruckBinding

class ListTruckAdapter(private val listTruk:ArrayList<Truck>) : RecyclerView.Adapter<ListTruckAdapter.ListViewHolder>(){

    private lateinit var onItemClickCallback : OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemListTruckBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listTruk[position]
        holder.binding.imgItemPhoto.setImageResource(photo)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listTruk[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int =
        listTruk.size

    class ListViewHolder(var binding: ItemListTruckBinding) : RecyclerView.ViewHolder(binding.root)

    interface OnItemClickCallback{
        fun onItemClicked(data : Truck)
    }

}
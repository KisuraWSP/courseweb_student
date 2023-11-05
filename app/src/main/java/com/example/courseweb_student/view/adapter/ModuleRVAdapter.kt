package com.example.courseweb_student.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ModuleRVAdapter {
}

/*
class ItemRVAdapter(

    var list: List<Items>,
    val itemClickInterface: ItemClickInterface
) : RecyclerView.Adapter<ItemRVAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameTV = itemView.findViewById<TextView>(R.id.idTVItemName)
        val quantityTV = itemView.findViewById<TextView>(R.id.idTVQuantity)
        val rateTv = itemView.findViewById<TextView>(R.id.idTVRate)
        val amountTV = itemView.findViewById<TextView>(R.id.idTVTotalAmount)
        val deleteIV = itemView.findViewById<ImageView>(R.id.idIVDelete)
    }

    interface ItemClickInterface{
        fun onItemClick(items: Items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_rv_item, parent, false)

        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.nameTV.text = list.get(position).item_name
        holder.quantityTV.text = list.get(position).item_quantity.toString()
        holder.rateTv.text = "Rs. " + list.get(position).item_price.toString()
        val itemTotal: Int = list.get(position).item_price * list.get(position).item_quantity
        holder.amountTV.text = "Rs " + itemTotal.toString()
        holder.deleteIV.setOnClickListener{
            itemClickInterface.onItemClick(list.get(position))
        }
    }
}
*/ /**/
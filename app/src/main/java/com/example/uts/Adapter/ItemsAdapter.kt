package com.example.uts.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uts.Domain.ItemsDomain
import com.example.uts.R
import com.example.uts.activites.DetailActivity
import java.text.DecimalFormat

class ItemsAdapter(private val items: ArrayList<ItemsDomain>) : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    private val formatter = DecimalFormat("###,###,###,##")
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_viewholder, parent, false)
        context = parent.context
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.themTxt.text = item.them
        holder.dateTxt.text = item.date
        holder.tittleTxt.text = item.tittle

        val drawableResourceId = holder.itemView.resources.getIdentifier(item.pic, "drawable", holder.itemView.context.packageName)
        Glide.with(holder.itemView.context)
            .load(drawableResourceId)
            .into(holder.pic)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("object", item)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val themTxt: TextView = itemView.findViewById(R.id.themTxt)
        val dateTxt: TextView = itemView.findViewById(R.id.dateTxt)
        val tittleTxt: TextView = itemView.findViewById(R.id.tittleTxt)
        val pic: ImageView = itemView.findViewById(R.id.pic)
    }
}

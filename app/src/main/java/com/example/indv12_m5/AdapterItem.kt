package com.example.indv12_m5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.indv12_m5.databinding.ItermListDataBinding

class AdapterItem(

    private val itemList : List<Item>,
    private val context : Context,
    private val listener : SendItem) : RecyclerView.Adapter<AdapterItem.ItemViewHolder>()

{

    inner class  ItemViewHolder( binding : ItermListDataBinding) :
            RecyclerView.ViewHolder(binding.getRoot()),View.OnClickListener{

        var imageView : ImageView
        var textView : TextView

        init {
            imageView = binding.imageItem
            textView = binding.textItem
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listener.sendItem(itemList[layoutPosition])
        }
    }

    interface SendItem{
        fun sendItem(item: Item?)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val binding  = ItermListDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val item = itemList[position]
        holder.textView.text = item.itemDescription

        Glide.with(context).load(item.itemUrl).centerCrop().override(300, 300)
            .into(holder.imageView)


    }


}
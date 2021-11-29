package com.oct18.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oct18.databinding.HomeItemLayoutBinding
import com.oct18.model.HomeItem

class HomeItemAdapter(private val data: ArrayList<HomeItem>,
                      val listener: OnHomeItemClickListener) : RecyclerView.Adapter<HomeItemAdapter.HomeItemViewHolder>() {

    interface OnHomeItemClickListener{
        fun onHomeItemClick(item : HomeItem)
    }

    class HomeItemViewHolder(val binding:HomeItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val binding=HomeItemLayoutBinding.inflate(inflater,parent,false)
        return HomeItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeItemViewHolder, position: Int) {
        val item=data[position]
        holder.binding.item=item

        holder.itemView.setOnClickListener {
            listener.onHomeItemClick(item)
        }
    }

    override fun getItemCount() = data.size


}
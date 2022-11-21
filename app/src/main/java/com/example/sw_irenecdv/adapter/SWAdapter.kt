package com.example.sw_irenecdv.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sw_irenecdv.R

class SWAdapter (var SWList:List<com.example.sw_irenecdv.Datos.Result>): RecyclerView.Adapter<SWViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SWViewHolder {
        val layoutInflate = LayoutInflater.from(parent.context)
        return SWViewHolder(layoutInflate.inflate(R.layout.item_personaje,parent,false))
    }

    override fun onBindViewHolder(holder: SWViewHolder, position: Int) {
        val item = SWList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return SWList.size
    }
}
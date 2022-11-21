package com.example.sw_irenecdv.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sw_irenecdv.R
import com.example.sw_irenecdv.databinding.ItemPersonajeBinding

class SWViewHolder (view: View) :RecyclerView.ViewHolder(view) {
    val binding = ItemPersonajeBinding.bind(view)

    fun render(SWModel: com.example.sw_irenecdv.Datos.Result){
        binding.Nombre.text = SWModel.name
        binding.ResultadoAltura.text = SWModel.height
        binding.ResultadoNPeliculas.text = SWModel.birth_year



    }



}
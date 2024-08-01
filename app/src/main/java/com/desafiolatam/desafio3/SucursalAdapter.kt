package com.desafiolatam.desafio3


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.desafiolatam.desafio3.model.Sucursal

class SucursalAdapter(
    private val sucursales: List<Sucursal>,
    private val onClick: (Sucursal) -> Unit
) : RecyclerView.Adapter<SucursalAdapter.SucursalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SucursalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sucursal_item, parent, false)
        return SucursalViewHolder(view)
    }

    override fun onBindViewHolder(holder: SucursalViewHolder, position: Int) {
        val sucursal = sucursales[position]
        holder.bind(sucursal)
        holder.itemView.setOnClickListener { onClick(sucursal) }
    }

    override fun getItemCount(): Int = sucursales.size

    class SucursalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nombreTextView: TextView = view.findViewById(R.id.nombreTextView)
        private val horarioTextView: TextView = view.findViewById(R.id.horarioTextView)
        private val imageView: ImageView = view.findViewById(R.id.imageView)

        fun bind(sucursal: Sucursal) {
            nombreTextView.text = sucursal.nombre
            horarioTextView.text = sucursal.horario
            imageView.setImageResource(sucursal.foto)
        }
    }
}

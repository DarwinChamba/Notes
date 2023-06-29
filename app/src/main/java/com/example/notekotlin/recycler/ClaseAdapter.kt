package com.example.notekotlin.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.notekotlin.R
import com.example.notekotlin.data.Notas
import com.example.notekotlin.viewmodel.NotasViewModel

class ClaseAdapter(val lista:List<Notas>):RecyclerView.Adapter<NoteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_recycler,parent,false)
        return NoteViewHolder(view)
    }

    override fun getItemCount()=lista.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val list_note=lista[position]
        holder.render(list_note)
    }

}
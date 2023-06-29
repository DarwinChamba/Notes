package com.example.notekotlin.recycler

import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.notekotlin.data.Notas
import com.example.notekotlin.databinding.ItemRecyclerBinding
import com.example.notekotlin.fragment.ListFragmentDirections

class NoteViewHolder(view:View):RecyclerView.ViewHolder(view) {
    val binding=ItemRecyclerBinding.bind(view)

    fun render(note: Notas){
        binding.titleRecycler.text=note.titulo
        binding.priorityRecycler.text=note.prioridad.toString()
        binding.timeRecycler.text=note.hora
        binding.dateRecycler.text=note.fecha
        binding.enviarDatos.setOnClickListener {
            val action=ListFragmentDirections.actionListFragmentToEditFragment(note)
            itemView.findNavController().navigate(action)
        }
    }

}
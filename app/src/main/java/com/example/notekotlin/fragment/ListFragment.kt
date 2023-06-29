package com.example.notekotlin.fragment

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notekotlin.Delete
import com.example.notekotlin.R
import com.example.notekotlin.data.Notas
import com.example.notekotlin.databinding.FragmentListBinding
import com.example.notekotlin.recycler.ClaseAdapter
import com.example.notekotlin.viewmodel.NotasViewModel


class ListFragment : Fragment() {
    private lateinit var binding:FragmentListBinding
    private lateinit var model:NotasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentListBinding.inflate(inflater,container,false)
        model=ViewModelProvider(this).get(NotasViewModel::class.java)
        binding.addNote.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment2)
        }
        getAllNotes()
        val itemTouchHelper=ItemTouchHelper(swipeDelete)
        itemTouchHelper.attachToRecyclerView(binding.recycler)
        return binding.root
    }
    val swipeDelete=object :Delete(){
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val position=viewHolder.adapterPosition
            model.delete(position)
        }

    }

    fun getAllNotes(){
        binding.recycler.apply {
            layoutManager=LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
        model.getAllNotas.observe(viewLifecycleOwner,{user->
            binding.recycler.adapter=ClaseAdapter(user)

        })
    }



}
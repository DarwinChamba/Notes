package com.example.notekotlin.fragment

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.notekotlin.R
import com.example.notekotlin.data.Notas
import com.example.notekotlin.databinding.FragmentEditBinding
import com.example.notekotlin.viewmodel.NotasViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date


class EditFragment : Fragment() {
    private lateinit var binding:FragmentEditBinding
    private val args by navArgs<EditFragmentArgs>()
    lateinit var  model:NotasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentEditBinding.inflate(inflater,container,false)
        model=ViewModelProvider(this).get(NotasViewModel::class.java)
        binding.priorityEdit.minValue=1
        binding.priorityEdit.maxValue=10
        binding.titleEdit.setText(args.currentNote.titulo)
        binding.descriptionEdit.setText(args.currentNote.description)
        binding.priorityEdit.setValue(args.currentNote.prioridad)
        binding.btnUpdateNote.setOnClickListener {
            validarDatos()
        }
        binding.btnDeleteNote.setOnClickListener {
            eliminarNota()
        }
        return binding.root
    }
    fun eliminarNota(){
        val dialog=AlertDialog.Builder(requireContext())
            .setTitle("Delete")
            .setMessage("Are you sure ?")
            .setPositiveButton("yes"){_,_->
                val note=Notas(args.currentNote.id,args.currentNote.titulo,args.currentNote.description,args.currentNote.prioridad,args.currentNote.fecha,args.currentNote.hora)

                Toast.makeText(requireContext(),"Delete successful",Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_editFragment_to_listFragment)

            }.setNegativeButton("No"){_,_->}
            .create().show()

    }
    fun validarDatos(){
        val title=binding.titleEdit.text.toString()
        val description=binding.descriptionEdit.text.toString()
        val priority=binding.priorityEdit.value
        if(verificarDatos(title, description, priority)){
            val note=Notas(args.currentNote.id,title,description,priority,getDate(),getTime())
            model.update(note)
            Toast.makeText(requireContext(),"update Note",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_editFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(),"error",Toast.LENGTH_SHORT).show()
        }
    }
    fun verificarDatos(title:String,description:String,priority:Int):Boolean{
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(description) && priority==0)
    }
    fun getDate():String{
        val fecha= Date()
        val simpleFormat=SimpleDateFormat("dd:MM:yyyy")
        val currentDate= simpleFormat.format(fecha)
        return currentDate

    }
    fun getTime():String{
        val time=Calendar.getInstance().time
        val simpleFormat=SimpleDateFormat("HH:mm")
        return simpleFormat.format(time)
    }


}
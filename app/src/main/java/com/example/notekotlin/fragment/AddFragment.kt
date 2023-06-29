package com.example.notekotlin.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.notekotlin.R
import com.example.notekotlin.data.Notas
import com.example.notekotlin.databinding.FragmentAddBinding
import com.example.notekotlin.viewmodel.NotasViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date


class AddFragment : Fragment() {
   private lateinit var binding:FragmentAddBinding
   private lateinit var model:NotasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAddBinding.inflate(inflater,container,false)
        model=ViewModelProvider(this).get(NotasViewModel::class.java)
        binding.priority.minValue=1
        binding.priority.maxValue=10
        binding.btnSavedNote.setOnClickListener {
            validadDatos()
        }
        return binding.root
    }
    fun validadDatos(){
        val title=binding.title.text.toString()
        val description=binding.description.text.toString()
        val priority=binding.priority.value
        if(verificarCampos(title,description,priority)){
            val note=Notas(0,title,description,priority,getDate(),getTime())
            model.insert(note)
            Toast.makeText(requireContext(),"Note Successful",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFragment2_to_listFragment)

        }else{
            Toast.makeText(requireContext(),"Error",Toast.LENGTH_SHORT).show()
        }
    }
    fun verificarCampos(title:String, description:String, priority: Int):Boolean{
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(description) && priority==0)
    }
    fun getDate():String{
        val currentDateTime = Date()
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        val dateTimeStr = dateFormat.format(currentDateTime)
        return dateTimeStr
    }
    fun getTime():String{
        val currentTime = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("HH:mm")
        val formattedTime = dateFormat.format(currentTime)
        return formattedTime
    }

}
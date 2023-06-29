package com.example.notekotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.notekotlin.data.Notas
import com.example.notekotlin.data.NotasDatabase
import com.example.notekotlin.repository.NotasRepositorio
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotasViewModel(application: Application): AndroidViewModel(application) {
    val getAllNotas: LiveData<List<Notas>>
    val repositorio: NotasRepositorio
    init {
        val userDao= NotasDatabase.getDatabase(application).notasDao()
        repositorio= NotasRepositorio(userDao)
        getAllNotas=repositorio.getAllNotas
    }
     fun insert(notas: Notas){
        viewModelScope.launch(Dispatchers.IO){
            repositorio.insert(notas)
        }
    }
    fun delete(id:Int){
        viewModelScope.launch(Dispatchers.IO){
            repositorio.delete(id)
        }
    }
    fun update(notas: Notas){
        viewModelScope.launch(Dispatchers.IO){
            repositorio.update(notas)
        }
    }
}
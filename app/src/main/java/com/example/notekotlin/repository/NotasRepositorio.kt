package com.example.notekotlin.repository

import androidx.lifecycle.LiveData
import com.example.notekotlin.data.Notas
import com.example.notekotlin.data.NotasDao

class NotasRepositorio(private val notasDao: NotasDao) {

    val getAllNotas: LiveData<List<Notas>> = notasDao.getAllNotas()

    suspend fun insert(notas: Notas){
        notasDao.insert(notas)
    }
    suspend fun delete(id:Int){
        notasDao.delete(id)
    }
    suspend fun update(notas: Notas){
        notasDao.update(notas)
    }
}
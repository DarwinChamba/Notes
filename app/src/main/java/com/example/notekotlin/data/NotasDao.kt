package com.example.notekotlin.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface  NotasDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(notas:Notas)

    @Query("delete from room_notas where id = :id")
    suspend fun delete(id:Int)

    @Update
    fun update(notas: Notas)

    @Query("select * from room_notas order by prioridad desc")
    fun getAllNotas(): LiveData<List<Notas>>

    @Query("select * from room_notas where titulo = :titulo")
    fun searchByTitle(titulo:String):LiveData<List<Notas>>


}
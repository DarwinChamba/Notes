package com.example.notekotlin.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "room_notas")
data  class Notas (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val titulo:String,
    val description:String,
    val prioridad:Int,
    val fecha:String,
    val hora:String
): Parcelable
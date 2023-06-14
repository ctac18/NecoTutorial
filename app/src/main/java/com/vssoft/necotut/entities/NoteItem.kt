package com.vssoft.necotut.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity("noteList")
data class NoteItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo("title")
    val title:String,
    @ColumnInfo("content")
    val content:String,
    @ColumnInfo("time")
    val time:String,
    @ColumnInfo("category")
    val category:String
): Serializable

package com.vssoft.necotut.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.vssoft.necotut.entities.NoteItem
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Query("SELECT * FROM noteList")
    fun getAllNotes(): Flow<List<NoteItem>>

    @Insert
    suspend fun insertNote(item:NoteItem)

}
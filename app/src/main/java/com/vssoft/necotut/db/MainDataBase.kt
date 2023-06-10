package com.vssoft.necotut.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vssoft.necotut.entities.LibraryItem
import com.vssoft.necotut.entities.NoteItem
import com.vssoft.necotut.entities.ShopingListItem
import com.vssoft.necotut.entities.ShopingListName

@Database(entities = [LibraryItem::class,NoteItem::class,ShopingListItem::class,ShopingListName::class], version = 1)
abstract class MainDataBase:RoomDatabase() {

    abstract fun getDao(): Dao
    companion object {
        @Volatile
        var INSTANCE: MainDataBase? = null
        fun getDataBase(context:Context): MainDataBase{
            return INSTANCE?: synchronized(this){
                Log.d("MyLog","im bifnim!")
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDataBase::class.java,
                    "shopping_list.db"
                ).build()
                Log.d("MyLog","im yoce!")
                INSTANCE = instance
                instance
            }
        }
    }
}
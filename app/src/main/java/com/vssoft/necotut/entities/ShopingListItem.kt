package com.vssoft.necotut.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("shoplist_item")
data class ShopingListItem(
    @PrimaryKey(autoGenerate = true)
    val id:Int?,
    @ColumnInfo("name")
    val name:String,
    @ColumnInfo("itemInfo")
    val itemInfo:String?,
    @ColumnInfo("itemCheked")
    val itemCheked:Int = 0,
    @ColumnInfo("listId")
    val listId: Int,
    @ColumnInfo("itemType")
    val itemType:String = "item"

)

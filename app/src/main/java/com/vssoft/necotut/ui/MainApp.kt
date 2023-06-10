package com.vssoft.necotut.ui

import android.app.Application
import com.vssoft.necotut.db.MainDataBase

class MainApp: Application() {
    val database by lazy { MainDataBase.getDataBase(this) }
}
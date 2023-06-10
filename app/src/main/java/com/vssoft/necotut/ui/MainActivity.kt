package com.vssoft.necotut.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.vssoft.necotut.R
import com.vssoft.necotut.databinding.ActivityMainBinding
import com.vssoft.necotut.db.MainDataBase
import com.vssoft.necotut.db.NoteAdapter
import com.vssoft.necotut.fragments.FragmentManager
import com.vssoft.necotut.fragments.NoteFragment


// cntrl alt l
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setBottomNavListener()

        val a = MainDataBase.getDataBase(this)
        Log.d("MyLog", "INSTANCE = ${MainDataBase.INSTANCE}")
        val b = MainDataBase.getDataBase(this)
        Log.d("MyLog", "INSTANCE = ${MainDataBase.INSTANCE}")

    }

    private fun setBottomNavListener() {
        binding.bNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.settings -> {
                    Log.d("MyLog", "Settings")
                }

                R.id.notes -> {
                    FragmentManager.setFragment(NoteFragment.newInstance(),this)
                }

                R.id.shop_list -> {
                    Log.d("MyLog", "List")
                }

                R.id.new_item -> {
                    Log.d("MyLog", "New")
                }
            }
            true
        }
    }
}
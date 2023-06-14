package com.vssoft.necotut.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.activityViewModels
import com.vssoft.necotut.databinding.FragmentNoteBinding
import com.vssoft.necotut.db.MainViewModel
import com.vssoft.necotut.ui.MainApp
import com.vssoft.necotut.ui.NewNoteActivity


class NoteFragment : BaseFragment() {
    private lateinit var binding: FragmentNoteBinding
    private lateinit var editLauncher: ActivityResultLauncher<Intent>

    private val mainViewModel:MainViewModel by activityViewModels{
        MainViewModel.MainViewModelFactory((context?.applicationContext as MainApp).database)
    }
    override fun onClickNew() {
        editLauncher.launch(Intent(activity,NewNoteActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onEditResult()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentNoteBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun onEditResult(){
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == Activity.RESULT_OK){
                Log.d("MyLog","title: ${it.data?.getStringExtra(TITLE_KEY)}")
                Log.d("MyLog","description: ${it.data?.getStringExtra(DESC_KEY)}")
            }
        }
    }

    companion object {
        const val TITLE_KEY = "title_key"
        const val DESC_KEY = "discription_key"
        @JvmStatic
        fun newInstance() = NoteFragment()
    }
}
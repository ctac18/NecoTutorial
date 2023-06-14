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
import androidx.recyclerview.widget.LinearLayoutManager
import com.vssoft.necotut.databinding.FragmentNoteBinding
import com.vssoft.necotut.db.MainViewModel
import com.vssoft.necotut.db.NoteAdapter
import com.vssoft.necotut.entities.NoteItem
import com.vssoft.necotut.ui.MainApp
import com.vssoft.necotut.ui.NewNoteActivity


class NoteFragment : BaseFragment() {
    private lateinit var binding: FragmentNoteBinding
    private lateinit var editLauncher: ActivityResultLauncher<Intent>
    private lateinit var adapter: NoteAdapter

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

    // Инит ресайклера когда вске нарисовано
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()
        observer()
    }
    private fun initRcView() = with(binding){
        rcViewNote.layoutManager = LinearLayoutManager(activity)
        adapter = NoteAdapter()
        rcViewNote.adapter = adapter
    }
    private fun observer(){
        mainViewModel.allNotes.observe(viewLifecycleOwner,{
            adapter.submitList(it)
        })
    }
    private fun onEditResult(){
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == Activity.RESULT_OK){

                mainViewModel.intsertNote(it.data?.getSerializableExtra(NEW_NOTE_KEY) as NoteItem)
            }
        }
    }

    companion object {
        const val NEW_NOTE_KEY = "note_key"
        @JvmStatic
        fun newInstance() = NoteFragment()
    }
}
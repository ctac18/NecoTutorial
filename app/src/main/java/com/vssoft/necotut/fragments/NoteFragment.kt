package com.vssoft.necotut.fragments

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.vssoft.necotut.databinding.FragmentNoteBinding
import com.vssoft.necotut.db.MainViewModel
import com.vssoft.necotut.ui.MainApp


class NoteFragment : BaseFragment() {
    private lateinit var binding: FragmentNoteBinding

    private val mainViewModel:MainViewModel by activityViewModels{
        MainViewModel.MainViewModelFactory((context?.applicationContext as MainApp).database)
    }
    override fun onClickNew() {
        TODO("Not yet implemented")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentNoteBinding.inflate(inflater,container,false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = NoteFragment()
    }
}
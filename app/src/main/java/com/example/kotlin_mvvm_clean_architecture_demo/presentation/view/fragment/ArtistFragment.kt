package com.example.kotlin_mvvm_clean_architecture_demo.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlin_mvvm_clean_architecture_demo.databinding.FragmentArtistBinding
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.viewmodel.ArtistViewModel
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.viewmodel.ArtistViewModelFactory

class ArtistFragment : Fragment() {
    private lateinit var binding : FragmentArtistBinding
    private lateinit var viewModel: ArtistViewModel
    private lateinit var viewModelFactory: ArtistViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentArtistBinding.inflate(inflater, container, false)
        initialize()
        return binding.root
    }

    private fun initialize() {
        binding.lifecycleOwner = this
//        viewModelFactory = ArtistViewModelFactory()
//        viewModel = ViewModelProvider(this, viewModelFactory).get(ArtistViewModel::class.java)
//        binding.mViewModel = viewModel
    }

    companion object {
        @JvmStatic
        fun newInstance() = ArtistFragment()
    }
}
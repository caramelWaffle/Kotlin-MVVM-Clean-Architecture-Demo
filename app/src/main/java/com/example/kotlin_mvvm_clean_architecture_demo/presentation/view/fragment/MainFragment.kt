package com.example.kotlin_mvvm_clean_architecture_demo.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.kotlin_mvvm_clean_architecture_demo.R
import com.example.kotlin_mvvm_clean_architecture_demo.databinding.FragmentMainBinding
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.viewmodel.MainViewModel

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        initView()
        return binding.root
    }

    private fun initView() {
        setActionBarTitle()
        binding.apply {
            btnMovie.setOnClickListener {
                it.findNavController().navigate(R.id.action_mainFragment_to_movieFragment)
            }
            btnArtist.setOnClickListener{
                it.findNavController().navigate(R.id.action_mainFragment_to_artistFragment)
            }
            btnTVShow.setOnClickListener {
                it.findNavController().navigate(R.id.action_mainFragment_to_TVShowFragment)
            }
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }

    private fun setActionBarTitle(){
        (requireActivity() as AppCompatActivity).supportActionBar?.title = mainViewModel.title.value.toString()
    }
}
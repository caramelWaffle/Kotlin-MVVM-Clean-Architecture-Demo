package com.example.kotlin_mvvm_clean_architecture_demo.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.kotlin_mvvm_clean_architecture_demo.R
import com.example.kotlin_mvvm_clean_architecture_demo.databinding.FragmentMainBinding
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.view.adapter.StateAdapter
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.viewmodel.MainViewModel
import com.google.android.material.tabs.TabLayoutMediator

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
        initViewPager2WithFragments()
    }

    private fun initViewPager2WithFragments() {
        val adapter = StateAdapter(requireActivity() as AppCompatActivity)
        binding.viewpager.adapter = adapter

        val names: Array<String> = arrayOf(
            requireContext().resources.getString(R.string.movie),
            requireContext().resources.getString(R.string.tv_show),
            requireContext().resources.getString(R.string.artist))


        TabLayoutMediator(binding.tablayout, binding.viewpager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = names[position]
            }).attach()
    }

    companion object {
        fun newInstance() = MainFragment()
    }

    private fun setActionBarTitle() {
        (requireActivity() as AppCompatActivity).supportActionBar?.title =
            mainViewModel.title.value.toString()
    }
}
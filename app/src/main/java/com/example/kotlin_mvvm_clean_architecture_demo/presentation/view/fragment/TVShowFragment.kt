package com.example.kotlin_mvvm_clean_architecture_demo.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_mvvm_clean_architecture_demo.R
import com.example.kotlin_mvvm_clean_architecture_demo.databinding.FragmentArtistBinding
import com.example.kotlin_mvvm_clean_architecture_demo.databinding.FragmentTVShowBinding
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.AppInjector
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.view.adapter.ArtistAdapter
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.view.adapter.TVShowAdapter
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.viewmodel.artist.ArtistViewModel
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.viewmodel.tvshow.TVShowViewModel
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.viewmodel.tvshow.TVShowViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class TVShowFragment : Fragment() {
    @Inject
    lateinit var viewModelfactory: TVShowViewModelFactory
    private lateinit var binding: FragmentTVShowBinding
    private lateinit var viewModel: TVShowViewModel
    private lateinit var tvShowAdapter: TVShowAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)

        AppInjector.getInstance(requireActivity().applicationContext)
            .createTVShowSubComponent()
            .inject(this)
        super.onCreate(savedInstanceState)    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTVShowBinding.inflate(inflater, container, false)
        initialize()
        return binding.root
    }

    private fun initialize() {
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this, viewModelfactory).get(TVShowViewModel::class.java)
        tvShowAdapter = TVShowAdapter()
        binding.tvRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = tvShowAdapter
        }
        fetchPopularArtist()
    }


    private fun fetchPopularArtist() {
        CoroutineScope(Dispatchers.Main).launch {
            viewModel.getTVShow().observe(viewLifecycleOwner, Observer {
                if (it != null) {
                    tvShowAdapter.setData(it)
                    binding.tvProgressBar.visibility = View.GONE
                } else {
                    binding.tvProgressBar.visibility = View.GONE
                    Toast.makeText(
                        requireActivity().applicationContext,
                        "No data available",
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TVShowFragment()
    }
}
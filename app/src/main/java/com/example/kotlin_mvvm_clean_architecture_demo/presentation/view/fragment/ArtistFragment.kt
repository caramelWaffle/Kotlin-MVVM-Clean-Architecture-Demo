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
import com.example.kotlin_mvvm_clean_architecture_demo.databinding.FragmentArtistBinding
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.AppInjector
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.view.adapter.ArtistAdapter
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.viewmodel.artist.ArtistViewModel
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.viewmodel.artist.ArtistViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ArtistFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ArtistViewModelFactory
    private lateinit var binding : FragmentArtistBinding
    private lateinit var viewModel: ArtistViewModel
    private lateinit var artistAdapter: ArtistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        AppInjector.getInstance(requireActivity().applicationContext)
            .createArtistSubComponent()
            .inject(this)

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
        viewModel = ViewModelProvider(this, viewModelFactory).get(ArtistViewModel::class.java)
        artistAdapter = ArtistAdapter()
        binding.artistRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = artistAdapter
        }
        fetchPopularArtist()
    }

    private fun fetchPopularArtist() {
        CoroutineScope(Dispatchers.Main).launch {
            viewModel.getArtist().observe(viewLifecycleOwner, Observer {
                if (it != null) {
                    artistAdapter.setData(it)
                    binding.artistProgressBar.visibility = View.GONE
                } else {
                    binding.artistProgressBar.visibility = View.GONE
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
        fun newInstance() = ArtistFragment()
    }
}
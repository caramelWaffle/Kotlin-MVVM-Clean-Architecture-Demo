package com.example.kotlin_mvvm_clean_architecture_demo.presentation.view.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_mvvm_clean_architecture_demo.R
import com.example.kotlin_mvvm_clean_architecture_demo.databinding.FragmentMovieBinding
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.AppInjector
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.view.adapter.MovieAdapter
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.viewmodel.MovieViewModel
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.viewmodel.MovieViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieFragment : Fragment() {
    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: FragmentMovieBinding
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        AppInjector.getInstance(requireActivity().applicationContext)
            .createMovieSubComponent()
            .inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        initialize()
        return binding.root
    }

    private fun initialize() {
        movieViewModel =
            ViewModelProvider(this, movieViewModelFactory).get(MovieViewModel::class.java)
        movieAdapter = MovieAdapter()
        binding.movieRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = movieAdapter
        }
        setActionBarTitle()
        fetchPopularMovie()
    }

    private fun fetchPopularMovie() {
//        binding.movieProgressBar.visibility = View.VISIBLE
//        val responseLiveData = movieViewModel.getMovies()
//        responseLiveData.observe(requireActivity(), Observer {
//            if (it != null) {
//                movieAdapter.setData(it)
//                movieAdapter.notifyDataSetChanged()
//                binding.movieProgressBar.visibility = View.GONE
//            } else {
//                binding.movieProgressBar.visibility = View.GONE
//                Toast.makeText(
//                    requireActivity().applicationContext,
//                    "No data available",
//                    Toast.LENGTH_LONG
//                ).show()
//            }
//        })
        CoroutineScope(Dispatchers.Main).launch {
            movieViewModel.getMoviePagedList().observe(viewLifecycleOwner, Observer {
                if (it != null) {
                    movieAdapter.submitList(it)
                    movieAdapter.notifyDataSetChanged()
                    binding.movieProgressBar.visibility = View.GONE
                } else {
                    binding.movieProgressBar.visibility = View.GONE
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
        fun newInstance() = MovieFragment()
    }

    private fun setActionBarTitle() {
        (requireActivity() as AppCompatActivity).supportActionBar?.title =
            movieViewModel.title.value.toString()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_update, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_update) {
            updateMovie()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun updateMovie() {
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseUpdateLiveData = movieViewModel.updateMovies()
        responseUpdateLiveData.observe(requireActivity(), Observer {
            if (it != null) {
                movieAdapter.setData(it)
                movieAdapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
                binding.movieRecyclerView.smoothScrollToPosition(0)
            } else {
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(
                    requireActivity().applicationContext,
                    "No new movie",
                    Toast.LENGTH_LONG
                ).show()
            }
        })
    }
}
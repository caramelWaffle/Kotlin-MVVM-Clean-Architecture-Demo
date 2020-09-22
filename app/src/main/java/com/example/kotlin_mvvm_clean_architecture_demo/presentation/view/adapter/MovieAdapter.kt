package com.example.kotlin_mvvm_clean_architecture_demo.presentation.view.adapter

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin_mvvm_clean_architecture_demo.R
import com.example.kotlin_mvvm_clean_architecture_demo.data.model.movie.Movie
import com.example.kotlin_mvvm_clean_architecture_demo.databinding.ItemMovieBinding


class MovieAdapter : PagedListAdapter<Movie, MovieAdapter.MyViewHolder>(Movie.diffCallback) {

    private var movieList = ArrayList<Movie>()


    fun setData(movies:List<Movie>){
        movieList.clear()
        movieList.addAll(movies)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(binding)
    }

//    override fun getItemCount(): Int {
//        return movieList.size
//    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindView(getItem(position)!!, position)
    }

    class MyViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(movie: Movie, position: Int){
            binding.titleTextView.text = movie.title
            binding.descriptionTextView.text = movie.overview
            val posterURL = Contextor.getContext().getString(R.string.image_endpoint)+movie.posterPath
            Glide.with(binding.imageView.context)
                .load(posterURL)
                .placeholder(R.drawable.placeholder)
                .into(binding.imageView)
        }
    }

}
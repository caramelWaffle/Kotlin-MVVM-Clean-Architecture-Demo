package com.example.kotlin_mvvm_clean_architecture_demo.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin_mvvm_clean_architecture_demo.R
import com.example.kotlin_mvvm_clean_architecture_demo.data.model.tvshow.TVShow
import com.example.kotlin_mvvm_clean_architecture_demo.databinding.ItemMovieBinding


class TVShowAdapter() : RecyclerView.Adapter<TVShowAdapter.TVShowViewHolder>() {

    private var tvShowsList = ArrayList<TVShow>()

    fun setData(tvShows :List<TVShow>){
        tvShowsList.clear()
        tvShowsList.addAll(tvShows)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(layoutInflater, parent, false)
        return TVShowViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return tvShowsList.size
    }

    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) {
        holder.bind(tvShowsList[position])
    }

    class TVShowViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(tvShow: TVShow) {
            binding.titleTextView.text = tvShow.name
            binding.descriptionTextView.text = tvShow.overview
            val posterURL = Contextor.getContext().getString(R.string.image_endpoint)+tvShow.posterPath
            Glide.with(binding.imageView.context)
                .load(posterURL)
                .placeholder(R.drawable.placeholder)
                .into(binding.imageView)
        }
    }

}
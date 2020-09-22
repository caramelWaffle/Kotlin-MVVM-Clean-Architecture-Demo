package com.example.kotlin_mvvm_clean_architecture_demo.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin_mvvm_clean_architecture_demo.R
import com.example.kotlin_mvvm_clean_architecture_demo.data.model.artist.Artist
import com.example.kotlin_mvvm_clean_architecture_demo.databinding.ItemMovieBinding


class ArtistAdapter() : RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder>() {

    private var artistList = ArrayList<Artist>()

    fun setData(artists :List<Artist>){
        artistList.clear()
        artistList.addAll(artists)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(layoutInflater, parent, false)
        return ArtistViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return artistList.size
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(artistList[position])
    }

    class ArtistViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(artist: Artist) {
            binding.titleTextView.text = artist.name
            val text = Contextor.getContext().getString(R.string.popularity) + ' ' + artist.popularity.toString()
            binding.descriptionTextView.text = text
            val posterURL = Contextor.getContext().getString(R.string.image_endpoint) + artist.profilePath
            Glide.with(binding.imageView.context)
                .load(posterURL)
                .placeholder(R.drawable.placeholder)
                .into(binding.imageView)
        }
    }

}
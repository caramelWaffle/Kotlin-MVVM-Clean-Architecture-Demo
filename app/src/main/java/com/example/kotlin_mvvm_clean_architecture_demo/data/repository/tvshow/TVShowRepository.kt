package com.example.kotlin_mvvm_clean_architecture_demo.data.repository.tvshow

import com.example.kotlin_mvvm_clean_architecture_demo.data.model.tvshow.TVShow


interface TVShowRepository {
    // contact with DAO

    suspend fun getTVShows(): List<TVShow>?

    suspend fun updateTVShows(): List<TVShow>?
}
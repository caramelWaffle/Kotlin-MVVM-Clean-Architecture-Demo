package com.example.kotlin_mvvm_clean_architecture_demo.data.repository.tvshow.datasource

import com.example.kotlin_mvvm_clean_architecture_demo.data.model.tvshow.TVShow


interface TVShowLocalDataSource {

    suspend fun getTVShowsFromDB(): List<TVShow>

    suspend fun saveTVShowsToDB(tvShow: List<TVShow>)

    suspend fun clearAll()
}
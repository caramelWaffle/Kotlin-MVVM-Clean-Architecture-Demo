package com.example.kotlin_mvvm_clean_architecture_demo.data.repository.tvshow.datasource

import com.example.kotlin_mvvm_clean_architecture_demo.data.model.tvshow.TVShow


interface TVShowCacheDataSource {

    suspend fun getTVShowsFromCache(): List<TVShow>

    suspend fun saveTVShowsToCache(tvShow: List<TVShow>)}
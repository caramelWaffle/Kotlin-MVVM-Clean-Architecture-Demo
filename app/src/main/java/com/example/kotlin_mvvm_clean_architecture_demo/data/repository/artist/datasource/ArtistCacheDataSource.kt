package com.example.kotlin_mvvm_clean_architecture_demo.data.repository.artist.datasource

import com.example.kotlin_mvvm_clean_architecture_demo.data.model.artist.Artist


interface ArtistCacheDataSource {

    suspend fun getArtistsFromCache(): List<Artist>

    suspend fun saveArtistsToCache(artists: List<Artist>)}
package com.example.kotlin_mvvm_clean_architecture_demo.data.repository.artist.datasource

import com.example.kotlin_mvvm_clean_architecture_demo.data.model.artist.Artist


interface ArtistLocalDataSource {

    suspend fun getArtistsFromDB(): List<Artist>

    suspend fun saveArtistsToDB(artist: List<Artist>)

    suspend fun clearAll()
}
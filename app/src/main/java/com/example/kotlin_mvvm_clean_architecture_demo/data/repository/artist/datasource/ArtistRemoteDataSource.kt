package com.example.kotlin_mvvm_clean_architecture_demo.data.repository.artist.datasource

import com.example.kotlin_mvvm_clean_architecture_demo.data.model.artist.Artist
import com.example.kotlin_mvvm_clean_architecture_demo.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {

    suspend fun getArtistsFromRemote(): Response<ArtistList>
}
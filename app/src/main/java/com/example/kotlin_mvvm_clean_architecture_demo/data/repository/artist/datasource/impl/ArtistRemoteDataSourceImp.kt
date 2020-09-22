package com.example.kotlin_mvvm_clean_architecture_demo.data.repository.artist.datasource.impl


import com.example.kotlin_mvvm_clean_architecture_demo.data.api.TMDBService
import com.example.kotlin_mvvm_clean_architecture_demo.data.model.artist.Artist
import com.example.kotlin_mvvm_clean_architecture_demo.data.model.artist.ArtistList
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImp(private val tmdbService: TMDBService, private val API_KEY: String) :
    ArtistRemoteDataSource {

    override suspend fun getArtistsFromRemote(): Response<ArtistList> {
        return tmdbService.getPopularArtists(API_KEY)
    }
}
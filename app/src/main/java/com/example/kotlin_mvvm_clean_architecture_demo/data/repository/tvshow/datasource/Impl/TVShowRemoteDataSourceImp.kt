package com.example.kotlin_mvvm_clean_architecture_demo.data.repository.tvshow.datasource.Impl


import com.example.kotlin_mvvm_clean_architecture_demo.data.api.TMDBService
import com.example.kotlin_mvvm_clean_architecture_demo.data.model.tvshow.TVShowList
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.tvshow.datasource.TVShowRemoteDataSource
import retrofit2.Response

class TVShowRemoteDataSourceImp(private val tmdbService: TMDBService, private val API_KEY: String) :
    TVShowRemoteDataSource {

    override suspend fun getTVShowsFromRemote(): Response<TVShowList> = tmdbService.getPopularTVShows(API_KEY)
}
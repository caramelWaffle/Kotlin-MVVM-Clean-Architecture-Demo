package com.example.kotlin_mvvm_clean_architecture_demo.data.repository.movie

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.kotlin_mvvm_clean_architecture_demo.data.api.TMDBService
import com.example.kotlin_mvvm_clean_architecture_demo.data.model.movie.Movie
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.movie.MovieRemoteDataSourceImp


class MovieRemoteDataSourceFactory(
    private val tmdbService: TMDBService,
    private val API_KEY: String
) : DataSource.Factory<Int, Movie>() {

    val sourceLiveData = MutableLiveData<MovieRemoteDataSourceImp>()

    override fun create(): DataSource<Int, Movie> {
        val source = MovieRemoteDataSourceImp(tmdbService, API_KEY)
        sourceLiveData.postValue(source)
        return source
    }

}
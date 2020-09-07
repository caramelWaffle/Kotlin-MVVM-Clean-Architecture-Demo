package com.example.kotlin_mvvm_clean_architecture_demo.data.repository.movie.datasource

import com.example.kotlin_mvvm_clean_architecture_demo.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMoviesFromRemote(): Response<MovieList>
}
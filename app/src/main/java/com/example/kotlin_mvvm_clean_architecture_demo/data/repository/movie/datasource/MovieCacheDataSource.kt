package com.example.kotlin_mvvm_clean_architecture_demo.data.repository.movie.datasource

import com.example.kotlin_mvvm_clean_architecture_demo.data.model.movie.Movie

interface MovieCacheDataSource {

    suspend fun getMoviesFromCache(): List<Movie>

    suspend fun saveMoviesToCache(movies: List<Movie>)}
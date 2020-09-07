package com.example.kotlin_mvvm_clean_architecture_demo.data.repository.movie.datasource

import com.example.kotlin_mvvm_clean_architecture_demo.data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB(): List<Movie>

    suspend fun saveMoviesToDB(movies: List<Movie>)

    suspend fun clearAll()
}
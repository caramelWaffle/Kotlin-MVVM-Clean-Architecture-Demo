package com.example.kotlin_mvvm_clean_architecture_demo.data.repository.movie.datasource.impl

import com.example.kotlin_mvvm_clean_architecture_demo.data.db.MovieDAO
import com.example.kotlin_mvvm_clean_architecture_demo.data.model.movie.Movie
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImp(private val movieDAO: MovieDAO) :
    MovieLocalDataSource {

    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDAO.getMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.deleteAllMovies()
        }
    }
}
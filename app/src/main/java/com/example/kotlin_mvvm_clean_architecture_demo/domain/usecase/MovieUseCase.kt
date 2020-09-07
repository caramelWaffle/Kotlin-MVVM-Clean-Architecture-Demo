package com.example.kotlin_mvvm_clean_architecture_demo.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.kotlin_mvvm_clean_architecture_demo.data.model.movie.Movie
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.MovieRepository

class MovieUseCase(private val movieRepository: MovieRepository) {
    // execute function

    suspend fun getMovies(): List<Movie>? = movieRepository.getMovies()

    suspend fun updateMovies(): List<Movie>? = movieRepository.updateMovies()

    suspend fun getMoviePagedList(): LiveData<PagedList<Movie>>? = movieRepository.getMoviePagedList()

}
package com.example.kotlin_mvvm_clean_architecture_demo.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.kotlin_mvvm_clean_architecture_demo.data.model.movie.Movie

interface MovieRepository {
    // contact with DAO

    suspend fun getMovies(): List<Movie>?

    suspend fun getMoviePagedList(): LiveData<PagedList<Movie>>

    suspend fun updateMovies(): List<Movie>?
}
package com.example.kotlin_mvvm_clean_architecture_demo.data.db

import androidx.room.*
import com.example.kotlin_mvvm_clean_architecture_demo.data.model.movie.Movie

@Dao
interface MovieDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("DELETE FROM ${Movie.TABLE_NAME}")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM ${Movie.TABLE_NAME}")
    suspend fun getMovies(): List<Movie>

}
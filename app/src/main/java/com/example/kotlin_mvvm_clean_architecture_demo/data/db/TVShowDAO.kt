package com.example.kotlin_mvvm_clean_architecture_demo.data.db

import androidx.room.*
import com.example.kotlin_mvvm_clean_architecture_demo.data.model.tvshow.TVShow

@Dao
interface TVShowDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTVShows(tvShows: List<TVShow>)

    @Query("DELETE FROM ${TVShow.TABLE_NAME}")
    suspend fun deleteAllTVShows()

    @Query("SELECT * FROM ${TVShow.TABLE_NAME}")
    suspend fun getTVShows(): List<TVShow>

}
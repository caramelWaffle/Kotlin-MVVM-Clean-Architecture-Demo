package com.example.kotlin_mvvm_clean_architecture_demo.data.db

import androidx.room.*
import com.example.kotlin_mvvm_clean_architecture_demo.data.model.artist.Artist

@Dao
interface ArtistDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artists: List<Artist>)

    @Query("DELETE FROM ${Artist.TABLE_NAME}")
    suspend fun deleteAllArtists()

    @Query("SELECT * FROM ${Artist.TABLE_NAME}")
    suspend fun getArtists(): List<Artist>

}
package com.example.kotlin_mvvm_clean_architecture_demo.data.repository.artist

import com.example.kotlin_mvvm_clean_architecture_demo.data.model.artist.Artist

interface ArtistRepository {
    // contact with DAO

    suspend fun getArtists(): List<Artist>?

    suspend fun updateArtists(): List<Artist>?
}
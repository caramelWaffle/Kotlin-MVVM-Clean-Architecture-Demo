package com.example.kotlin_mvvm_clean_architecture_demo.domain.usecase

import com.example.kotlin_mvvm_clean_architecture_demo.data.model.artist.Artist
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.artist.ArtistRepository


class ArtistUseCase(private val artistRepository: ArtistRepository) {
    // execute function

    suspend fun getArtists(): List<Artist>? = artistRepository.getArtists()

    suspend fun updateArtists(): List<Artist>? = artistRepository.updateArtists()

}
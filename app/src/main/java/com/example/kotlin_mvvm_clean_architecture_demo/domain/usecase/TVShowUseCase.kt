package com.example.kotlin_mvvm_clean_architecture_demo.domain.usecase

import com.example.kotlin_mvvm_clean_architecture_demo.data.model.tvshow.TVShow
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.TVShowRepository


class TVShowUseCase(private val tvShowRepository: TVShowRepository) {
    // execute function

    suspend fun getTVShows(): List<TVShow>? = tvShowRepository.getTVShows()

    suspend fun updateTVShows(): List<TVShow>? = tvShowRepository.updateTVShows()


}
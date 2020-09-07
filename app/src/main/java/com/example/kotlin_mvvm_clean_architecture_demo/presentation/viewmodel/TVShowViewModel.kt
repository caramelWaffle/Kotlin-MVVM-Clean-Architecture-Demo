package com.example.kotlin_mvvm_clean_architecture_demo.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.kotlin_mvvm_clean_architecture_demo.domain.usecase.TVShowUseCase

class TVShowViewModel(private val tvShowUseCase: TVShowUseCase): ViewModel() {

    fun getMovies() = liveData {
        emit(tvShowUseCase.getTVShows())
    }

    fun updateMovies() = liveData {
        emit(tvShowUseCase.updateTVShows())
    }

}
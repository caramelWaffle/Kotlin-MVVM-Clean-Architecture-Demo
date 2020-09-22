package com.example.kotlin_mvvm_clean_architecture_demo.presentation.viewmodel.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.kotlin_mvvm_clean_architecture_demo.domain.usecase.TVShowUseCase

class TVShowViewModel(private val tvShowUseCase: TVShowUseCase): ViewModel() {

    fun getTVShow() = liveData {
        emit(tvShowUseCase.getTVShows())
    }

    fun updateTVShow() = liveData {
        emit(tvShowUseCase.updateTVShows())
    }

}
package com.example.kotlin_mvvm_clean_architecture_demo.presentation.viewmodel.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.kotlin_mvvm_clean_architecture_demo.domain.usecase.ArtistUseCase

class ArtistViewModel(private val useCase: ArtistUseCase): ViewModel() {

    fun getArtist() = liveData {
        emit(useCase.getArtists())
    }

    fun updateArtist() = liveData {
        emit(useCase.updateArtists())
    }

}
package com.example.kotlin_mvvm_clean_architecture_demo.presentation.viewmodel.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_mvvm_clean_architecture_demo.domain.usecase.ArtistUseCase

@Suppress("UNCHECKED_CAST")
class ArtistViewModelFactory(private val artistUseCase: ArtistUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ArtistViewModel::class.java)){
            return ArtistViewModel(
                artistUseCase
            ) as T
        }
        throw IllegalArgumentException()
    }
}
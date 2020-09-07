package com.example.kotlin_mvvm_clean_architecture_demo.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_mvvm_clean_architecture_demo.domain.usecase.TVShowUseCase

class TVShowViewModelFactory(private val tvShowUseCase: TVShowUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TVShowViewModel::class.java)){
            return TVShowViewModel(tvShowUseCase) as T
        }
        throw IllegalArgumentException()
    }
}
package com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.tvshow

import com.example.kotlin_mvvm_clean_architecture_demo.domain.usecase.TVShowUseCase
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.viewmodel.TVShowViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TVShowModule {

    @Provides
    @TVShowScope
    fun provideTVShowViewModelFactory(tvShowUseCase: TVShowUseCase): TVShowViewModelFactory{
        return TVShowViewModelFactory(tvShowUseCase)
    }

}
package com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.artist

import com.example.kotlin_mvvm_clean_architecture_demo.domain.usecase.ArtistUseCase
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.viewmodel.ArtistViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ArtistModule {

    @Provides
    @ArtistScope
    fun provideArtistViewModelFactory(artistUseCase: ArtistUseCase): ArtistViewModelFactory{
        return ArtistViewModelFactory(artistUseCase)
    }

}
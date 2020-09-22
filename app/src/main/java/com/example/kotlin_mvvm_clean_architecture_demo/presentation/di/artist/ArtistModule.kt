package com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.artist

import com.example.kotlin_mvvm_clean_architecture_demo.domain.usecase.ArtistUseCase
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.viewmodel.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @Provides
    @ArtistScope
    fun provideArtistViewModelFactory(artistUseCase: ArtistUseCase): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            artistUseCase
        )
    }

}
package com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.core

import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.artist.ArtistRepository
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.movie.MovieRepository
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.tvshow.TVShowRepository
import com.example.kotlin_mvvm_clean_architecture_demo.domain.usecase.ArtistUseCase
import com.example.kotlin_mvvm_clean_architecture_demo.domain.usecase.MovieUseCase
import com.example.kotlin_mvvm_clean_architecture_demo.domain.usecase.TVShowUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideMovieUseCase(movieRepository: MovieRepository): MovieUseCase{
        return MovieUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideArtistUseCase(artistRepository: ArtistRepository): ArtistUseCase{
        return ArtistUseCase(artistRepository)
    }

    @Singleton
    @Provides
    fun provideTVShowUseCase(tvShowRepository: TVShowRepository): TVShowUseCase{
        return TVShowUseCase(tvShowRepository)
    }


}
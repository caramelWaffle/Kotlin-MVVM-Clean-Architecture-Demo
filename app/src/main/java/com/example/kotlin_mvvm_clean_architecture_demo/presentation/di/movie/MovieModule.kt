package com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.movie

import com.example.kotlin_mvvm_clean_architecture_demo.domain.usecase.MovieUseCase
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.viewmodel.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @Provides
    @MovieScope
    fun provideMovieViewModelFactory(movieUseCase: MovieUseCase): MovieViewModelFactory {
        return MovieViewModelFactory(
            movieUseCase
        )
    }

}
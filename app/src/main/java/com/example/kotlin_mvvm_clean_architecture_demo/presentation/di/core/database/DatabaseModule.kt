package com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.core.database

import android.content.Context
import com.example.kotlin_mvvm_clean_architecture_demo.data.db.ArtistDAO
import com.example.kotlin_mvvm_clean_architecture_demo.data.db.MovieDAO
import com.example.kotlin_mvvm_clean_architecture_demo.data.db.TMDBDatabase
import com.example.kotlin_mvvm_clean_architecture_demo.data.db.TVShowDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): TMDBDatabase{
        return TMDBDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideMovieDao(database: TMDBDatabase): MovieDAO = database.movieDAO()

    @Singleton
    @Provides
    fun provideArtistDao(database: TMDBDatabase): ArtistDAO = database.artistDAO()

    @Singleton
    @Provides
    fun provideTVShowDao(database: TMDBDatabase): TVShowDAO = database.tvShowDAO()
}
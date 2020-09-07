package com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.core.data

import com.example.kotlin_mvvm_clean_architecture_demo.data.db.ArtistDAO
import com.example.kotlin_mvvm_clean_architecture_demo.data.db.MovieDAO
import com.example.kotlin_mvvm_clean_architecture_demo.data.db.TVShowDAO
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.artist.ArtistLocalDataSourceImp
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.movie.MovieLocalDataSourceImp
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.movie.datasource.MovieLocalDataSource
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.tvshow.TVShowLocalDataSourceImp
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.tvshow.datasource.TVShowLocalDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDAO: MovieDAO): MovieLocalDataSource{
        return MovieLocalDataSourceImp(movieDAO)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDAO: ArtistDAO): ArtistLocalDataSource{
        return ArtistLocalDataSourceImp(artistDAO)
    }

    @Singleton
    @Provides
    fun provideTVShowLocalDataSource(tvShowDAO: TVShowDAO): TVShowLocalDataSource{
        return TVShowLocalDataSourceImp(tvShowDAO)
    }
}
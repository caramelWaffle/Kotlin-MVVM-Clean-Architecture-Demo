package com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.core.data

import com.example.kotlin_mvvm_clean_architecture_demo.data.api.TMDBService
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.artist.ArtistRemoteDataSourceImp
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.movie.MovieRemoteDataSourceFactory
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.movie.MovieRemoteDataSourceImp
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.tvshow.TVShowRemoteDataSourceImp
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.tvshow.datasource.TVShowRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val API_KEY : String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService) : MovieRemoteDataSource{
        return MovieRemoteDataSourceImp(tmdbService, API_KEY)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService) : ArtistRemoteDataSource{
        return ArtistRemoteDataSourceImp(tmdbService, API_KEY)
    }

    @Singleton
    @Provides
    fun provideTVShowRemoteDataSource(tmdbService: TMDBService) : TVShowRemoteDataSource{
        return TVShowRemoteDataSourceImp(tmdbService, API_KEY)
    }

    @Singleton
    @Provides
    fun provideMovieRemoteDataSourceFactory(tmdbService: TMDBService) : MovieRemoteDataSourceFactory{
        return MovieRemoteDataSourceFactory(tmdbService, API_KEY)
    }
}
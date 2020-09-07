package com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.core.data

import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.artist.ArtistRepositoryImp
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.movie.MovieRepositoryImp
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.movie.datasource.MovieCacheDataSource
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.movie.datasource.MovieLocalDataSource
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.tvshow.datasource.TVShowCacheDataSource
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.tvshow.datasource.TVShowLocalDataSource
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.tvshow.datasource.TVShowRemoteDataSource
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.tvshow.datasource.TVShowRepositoryImp
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.ArtistRepository
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.MovieRepository
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.TVShowRepository
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.movie.MovieRemoteDataSourceFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource,
        movieRepositoryFactory: MovieRemoteDataSourceFactory
    ): MovieRepository = MovieRepositoryImp(movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource, movieRepositoryFactory)

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository = ArtistRepositoryImp(artistRemoteDataSource, artistLocalDataSource, artistCacheDataSource)


    @Singleton
    @Provides
    fun provideTVShowRepository(
        tvShowRemoteDataSource: TVShowRemoteDataSource,
        tvShowLocalDataSource: TVShowLocalDataSource,
        tvShowCacheDataSource: TVShowCacheDataSource
    ): TVShowRepository = TVShowRepositoryImp(tvShowRemoteDataSource, tvShowLocalDataSource, tvShowCacheDataSource)

}
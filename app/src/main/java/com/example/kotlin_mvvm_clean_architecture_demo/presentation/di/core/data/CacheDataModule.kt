package com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.core.data

import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.artist.datasource.impl.ArtistCacheDataSourceImpl
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.movie.datasource.impl.MovieCacheDataSourceImpl
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.movie.datasource.MovieCacheDataSource
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.tvshow.datasource.Impl.TvShowCacheDataSourceImpl
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.tvshow.datasource.TVShowCacheDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource{
        return ArtistCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTVShowCacheDataSource(): TVShowCacheDataSource{
        return TvShowCacheDataSourceImpl()
    }

}
package com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.core

import com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.artist.ArtistSupComponent
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.core.data.CacheDataModule
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.core.data.LocalDataModule
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.core.data.RemoteDataModule
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.core.data.RepositoryModule
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.core.database.DatabaseModule
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.movie.MovieSupComponent
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.tvshow.TVShowSupComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
    AppModule::class,
    NetModule::class,
    DatabaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class
    ]
)
interface AppComponent {

    fun movieSubComponent(): MovieSupComponent.Factory

    fun artistSubComponent(): ArtistSupComponent.Factory

    fun tvShowSubComponent(): TVShowSupComponent.Factory
}
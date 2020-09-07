package com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.core

import android.content.Context
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.artist.ArtistSupComponent
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.movie.MovieSupComponent
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.tvshow.TVShowSupComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSupComponent::class,ArtistSupComponent::class,TVShowSupComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return context.applicationContext
    }





}
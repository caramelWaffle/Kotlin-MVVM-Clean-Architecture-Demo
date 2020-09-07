package com.example.kotlin_mvvm_clean_architecture_demo.presentation.di

import android.content.Context
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.artist.ArtistSupComponent
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.movie.MovieSupComponent
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.tvshow.TVShowSupComponent

interface Injector {

    fun initDagger()

    fun createMovieSubComponent(): MovieSupComponent

    fun createArtistSubComponent(): ArtistSupComponent

    fun createTVShowSubComponent(): TVShowSupComponent
}
package com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.movie

import com.example.kotlin_mvvm_clean_architecture_demo.presentation.view.fragment.ArtistFragment
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.view.fragment.MovieFragment
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSupComponent {

    fun inject(movieFragment: MovieFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create(): MovieSupComponent
    }
}
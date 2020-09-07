package com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.tvshow

import com.example.kotlin_mvvm_clean_architecture_demo.presentation.view.fragment.MovieFragment
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.view.fragment.TVShowFragment
import dagger.Subcomponent

@TVShowScope
@Subcomponent(modules = [TVShowModule::class])
interface TVShowSupComponent {

    fun inject(tvShowFragment: TVShowFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create(): TVShowSupComponent
    }
}
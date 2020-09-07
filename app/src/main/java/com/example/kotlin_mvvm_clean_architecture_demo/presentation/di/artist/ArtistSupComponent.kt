package com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.artist

import com.example.kotlin_mvvm_clean_architecture_demo.presentation.view.fragment.ArtistFragment
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSupComponent {

    fun inject(artistFragment: ArtistFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create(): ArtistSupComponent
    }
}
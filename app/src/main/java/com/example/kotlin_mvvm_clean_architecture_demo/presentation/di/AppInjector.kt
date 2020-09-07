package com.example.kotlin_mvvm_clean_architecture_demo.presentation.di

import android.content.Context
import com.example.kotlin_mvvm_clean_architecture_demo.R
import com.example.kotlin_mvvm_clean_architecture_demo.SingletonHolder
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.artist.ArtistSupComponent
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.core.AppComponent
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.core.AppModule
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.core.DaggerAppComponent
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.core.NetModule
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.core.data.RemoteDataModule
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.movie.MovieSupComponent
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.tvshow.TVShowSupComponent

class AppInjector private constructor(context: Context): Injector {
    private lateinit var applicationContext: Context
    private lateinit var appComponent : AppComponent

    init {
        this.applicationContext = context
        initDagger()
    }

    override fun initDagger() {
        appComponent = DaggerAppComponent.builder()
            .appModule(
                AppModule(
                    applicationContext
                )
            )
            .netModule(
                NetModule(
                    getSting(R.string.base_url)
                )
            )
            .remoteDataModule(RemoteDataModule(getSting(R.string.TMDB_API_KEY)))
            .build()
    }

    override fun createMovieSubComponent(): MovieSupComponent = appComponent.movieSubComponent().create()

    override fun createArtistSubComponent(): ArtistSupComponent = appComponent.artistSubComponent().create()

    override fun createTVShowSubComponent(): TVShowSupComponent = appComponent.tvShowSubComponent().create()

    private fun getSting(id: Int): String = applicationContext.resources.getString(id)

    companion object : SingletonHolder<AppInjector, Context>(::AppInjector)
}


package com.example.kotlin_mvvm_clean_architecture_demo.data.repository.tvshow.datasource.Impl

import com.example.kotlin_mvvm_clean_architecture_demo.data.model.tvshow.TVShow
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.tvshow.datasource.TVShowCacheDataSource
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.tvshow.datasource.TVShowLocalDataSource


class TvShowCacheDataSourceImpl : TVShowCacheDataSource {
    private var tvShowList = ArrayList<TVShow>()


    override suspend fun getTVShowsFromCache(): List<TVShow> {
        return tvShowList
    }

    override suspend fun saveTVShowsToCache(tvShow: List<TVShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShow)
    }
}
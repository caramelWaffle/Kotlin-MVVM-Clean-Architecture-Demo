package com.example.kotlin_mvvm_clean_architecture_demo.data.repository.tvshow.datasource

import android.util.Log
import com.example.kotlin_mvvm_clean_architecture_demo.data.model.tvshow.TVShow
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.TVShowRepository


class TVShowRepositoryImp(
    private val tvShowRemoteDataSource: TVShowRemoteDataSource,
    private val tvShowLocalDataSource: TVShowLocalDataSource,
    private val tvShowCacheDataSource: TVShowCacheDataSource
) : TVShowRepository {

    override suspend fun getTVShows(): List<TVShow>? = getTVShowsFromCache()

    override suspend fun updateTVShows(): List<TVShow>? {
        val newTvShowsList = getTVShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTVShowsToDB(newTvShowsList)
        tvShowCacheDataSource.saveTVShowsToCache(newTvShowsList)
        return newTvShowsList
    }

    suspend fun getTVShowsFromAPI(): List<TVShow> {
        val tvShowsList = ArrayList<TVShow>()
        try {
            val response = tvShowRemoteDataSource.getTVShowsFromRemote()
            val body = response.body()
            tvShowsList.addAll(body!!.TVShows)
        } catch (e: Exception) {
            Log.i("myTag", e.message.toString())
        }
        return tvShowsList
    }

    suspend fun getTVShowsFromDB(): List<TVShow> {
        val tvShowsList = ArrayList<TVShow>()
        try {
            tvShowsList.addAll(tvShowLocalDataSource.getTVShowsFromDB())
        } catch (e: Exception) {
            Log.i("myTag", e.message.toString())
        }

        if (tvShowsList.size == 0) {
            tvShowsList.addAll(getTVShowsFromAPI())
            tvShowLocalDataSource.saveTVShowsToDB(tvShowsList)
        }
        return tvShowsList

    }

    suspend fun getTVShowsFromCache(): List<TVShow>{
        val tvShowsList = ArrayList<TVShow>()
        try {
            tvShowsList.addAll(tvShowCacheDataSource.getTVShowsFromCache())
        } catch (e: Exception) {
            Log.i("myTag", e.message.toString())
        }

        if (tvShowsList.size == 0) {
            tvShowsList.addAll(getTVShowsFromDB())
            tvShowCacheDataSource.saveTVShowsToCache(tvShowsList)
        }
        return tvShowsList
    }




}
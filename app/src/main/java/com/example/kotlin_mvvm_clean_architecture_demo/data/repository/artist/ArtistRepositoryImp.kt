package com.example.kotlin_mvvm_clean_architecture_demo.data.repository.artist

import android.util.Log
import com.example.kotlin_mvvm_clean_architecture_demo.data.model.artist.Artist
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.artist.datasource.ArtistRemoteDataSource


class ArtistRepositoryImp(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {

    override suspend fun getArtists(): List<Artist>? = getArtistFromCache()

    override suspend fun updateArtists(): List<Artist>? {
        val newArtistList = getArtistFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newArtistList)
        artistCacheDataSource.saveArtistsToCache(newArtistList)
        return newArtistList
    }

    suspend fun getArtistFromAPI(): List<Artist> {
        val artistList = ArrayList<Artist>()
        try {
            val response = artistRemoteDataSource.getArtistsFromRemote()
            val body = response.body()
            artistList.addAll(body!!.people)
        } catch (e: Exception) {
            Log.i("myTag", e.message.toString())
        }
        return artistList
    }

    suspend fun getArtistFromDB(): List<Artist> {
        val artistList = ArrayList<Artist>()
        try {
            artistList.addAll(artistLocalDataSource.getArtistsFromDB())
        } catch (e: Exception) {
            Log.i("myTag", e.message.toString())
        }

        if (artistList.size == 0) {
            artistList.addAll(getArtistFromAPI())
            artistLocalDataSource.saveArtistsToDB(artistList)
        }
        return artistList

    }

    suspend fun getArtistFromCache(): List<Artist>{
        val artistList = ArrayList<Artist>()
        try {
            artistList.addAll(artistCacheDataSource.getArtistsFromCache())
        } catch (e: Exception) {
            Log.i("myTag", e.message.toString())
        }

        if (artistList.size == 0) {
            artistList.addAll(getArtistFromDB())
            artistCacheDataSource.saveArtistsToCache(artistList)
        }
        return artistList
    }


}
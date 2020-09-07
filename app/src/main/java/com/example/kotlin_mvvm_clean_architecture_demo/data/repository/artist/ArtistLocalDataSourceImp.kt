package com.example.kotlin_mvvm_clean_architecture_demo.data.repository.artist

import com.example.kotlin_mvvm_clean_architecture_demo.data.db.ArtistDAO
import com.example.kotlin_mvvm_clean_architecture_demo.data.model.artist.Artist
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImp(private val artistDAO: ArtistDAO) :
    ArtistLocalDataSource {


    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistDAO.getArtists()
    }

    override suspend fun saveArtistsToDB(artist: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDAO.saveArtists(artist)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDAO.deleteAllArtists()
        }
    }
}
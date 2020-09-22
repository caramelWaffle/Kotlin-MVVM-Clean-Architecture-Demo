package com.example.kotlin_mvvm_clean_architecture_demo.data.repository.tvshow.datasource.Impl


import com.example.kotlin_mvvm_clean_architecture_demo.data.db.TVShowDAO
import com.example.kotlin_mvvm_clean_architecture_demo.data.model.tvshow.TVShow
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.tvshow.datasource.TVShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TVShowLocalDataSourceImp(private val tvShowDAO: TVShowDAO) :
    TVShowLocalDataSource {

    override suspend fun getTVShowsFromDB(): List<TVShow> = tvShowDAO.getTVShows()

    override suspend fun saveTVShowsToDB(tvShow: List<TVShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDAO.saveTVShows(tvShow)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDAO.deleteAllTVShows()
        }
    }


}
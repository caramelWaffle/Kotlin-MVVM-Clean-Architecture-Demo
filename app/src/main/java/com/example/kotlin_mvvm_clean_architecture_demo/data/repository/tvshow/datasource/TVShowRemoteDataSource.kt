package com.example.kotlin_mvvm_clean_architecture_demo.data.repository.tvshow.datasource

import com.example.kotlin_mvvm_clean_architecture_demo.data.model.tvshow.TVShowList
import retrofit2.Response

interface TVShowRemoteDataSource {

    suspend fun getTVShowsFromRemote(): Response<TVShowList>
}
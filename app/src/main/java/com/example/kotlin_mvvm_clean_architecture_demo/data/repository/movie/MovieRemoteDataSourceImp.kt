package com.example.kotlin_mvvm_clean_architecture_demo.data.repository.movie

import androidx.paging.PageKeyedDataSource
import com.example.kotlin_mvvm_clean_architecture_demo.data.api.TMDBService
import com.example.kotlin_mvvm_clean_architecture_demo.data.model.movie.Movie
import com.example.kotlin_mvvm_clean_architecture_demo.data.model.movie.MovieList
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.movie.datasource.MovieRemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

private const val TMDB_STARTING_PAGE_INDEX = 1

class MovieRemoteDataSourceImp(private val tmdbService: TMDBService, private val API_KEY: String) :
    MovieRemoteDataSource, PageKeyedDataSource<Int, Movie>() {

    override suspend fun getMoviesFromRemote(): Response<MovieList> {
        return tmdbService.getPopularMovies(API_KEY)
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Movie>
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = async(Dispatchers.IO){
                tmdbService.getPopularMoviesWithPaging(API_KEY, TMDB_STARTING_PAGE_INDEX)
            }
            val movies = async(Dispatchers.IO){
                response.await().body()!!.movies
            }
            callback.onResult(movies.await(), null, TMDB_STARTING_PAGE_INDEX + 1)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = tmdbService.getPopularMoviesWithPaging(API_KEY, params.key)
            if(response.body() != null){
                val movies = response.body()!!.movies
                callback.onResult(movies, if (movies.isEmpty()) null else params.key + 1)
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {

    }


}
package com.example.kotlin_mvvm_clean_architecture_demo.data.repository.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.kotlin_mvvm_clean_architecture_demo.data.model.movie.Movie
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.movie.datasource.MovieCacheDataSource
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.movie.datasource.MovieLocalDataSource
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.kotlin_mvvm_clean_architecture_demo.data.repository.movie.datasource.impl.MovieRemoteDataSourceFactory

class MovieRepositoryImp(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource,
    private val movieRemoteDataSourceFactory: MovieRemoteDataSourceFactory
) : MovieRepository {



    override suspend fun getMovies(): List<Movie>? {
        return getMovieFromCache()
    }

    override suspend fun getMoviePagedList(): LiveData<PagedList<Movie>>  {
        val pageSize = 20
        val sourceFactory = movieRemoteDataSourceFactory
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(pageSize*2)
            .setPageSize(pageSize)
            .setPrefetchDistance(5)
            .build()

        return LivePagedListBuilder(sourceFactory, config).build()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newMovieList = getMovieFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newMovieList)
        movieCacheDataSource.saveMoviesToCache(newMovieList)
        return newMovieList
    }


    suspend fun getMovieFromAPI(): List<Movie> {
        val movieList = ArrayList<Movie>()
        try {
            val response = movieRemoteDataSource.getMoviesFromRemote()
            val body = response.body()
            movieList.addAll(body!!.movies)
        } catch (e: Exception) {
            Log.i("myTag", e.message.toString())
        }
        return movieList
    }

    suspend fun getMovieFromDB(): List<Movie> {
        val movieList = ArrayList<Movie>()
        try {
            movieList.addAll(movieLocalDataSource.getMoviesFromDB())
        } catch (e: Exception) {
            Log.i("myTag", e.message.toString())
        }

        if (movieList.size == 0) {
            movieList.addAll(getMovieFromAPI())
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList

    }

    suspend fun getMovieFromCache(): List<Movie>{
        val movieList = ArrayList<Movie>()
        try {
            movieList.addAll(movieCacheDataSource.getMoviesFromCache())
        } catch (e: Exception) {
            Log.i("myTag", e.message.toString())
        }

        if (movieList.size == 0) {
            movieList.addAll(getMovieFromDB())
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}
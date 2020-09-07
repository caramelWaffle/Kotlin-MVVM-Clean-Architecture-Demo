package com.example.kotlin_mvvm_clean_architecture_demo.data.api

import com.example.kotlin_mvvm_clean_architecture_demo.data.model.artist.ArtistList
import com.example.kotlin_mvvm_clean_architecture_demo.data.model.movie.MovieList
import com.example.kotlin_mvvm_clean_architecture_demo.data.model.tvshow.TVShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key")
        APIKey: String): Response<MovieList>

    @GET("movie/popular")
    suspend fun getPopularMoviesWithPaging(
        @Query("api_key")
        APIKey: String,
        @Query("page")
        page: Int): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTVShows(
        @Query("api_key")
        APIKey: String): Response<TVShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(
        @Query("api_key")
        APIKey: String): Response<ArtistList>

}
package com.example.kotlin_mvvm_clean_architecture_demo.presentation.viewmodel.movie

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import androidx.paging.PagedList
import androidx.recyclerview.widget.DiffUtil
import com.example.kotlin_mvvm_clean_architecture_demo.data.model.movie.Movie
import com.example.kotlin_mvvm_clean_architecture_demo.domain.usecase.MovieUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.internal.wait

class MovieViewModel(private val movieUseCase: MovieUseCase): ViewModel() {

    val title = MutableLiveData<String>()

    init {
        this.title.value = "Popular Movies"
    }

    fun getMovies() = liveData {
        emit(movieUseCase.getMovies())
    }

    fun updateMovies() = liveData {
        emit(movieUseCase.updateMovies())
    }

    suspend fun getMoviePagedList(): LiveData<PagedList<Movie>> {
        return movieUseCase.getMoviePagedList()!!
    }

//    suspend fun getMoviePagedList() = liveData<PagedList<Movie>> {
//        emit(movieUseCase.getMoviePagedList())
//    }
//


}
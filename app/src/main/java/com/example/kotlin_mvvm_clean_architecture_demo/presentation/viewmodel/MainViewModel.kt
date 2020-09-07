package com.example.kotlin_mvvm_clean_architecture_demo.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    val title = MutableLiveData<String>()

    init {
        this.title.value = "The Movie Database"
    }

}
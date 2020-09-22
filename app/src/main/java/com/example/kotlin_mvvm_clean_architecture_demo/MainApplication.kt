package com.example.kotlin_mvvm_clean_architecture_demo

import android.app.Application
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.di.AppInjector

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        AppInjector.getInstance(applicationContext).initDagger()
        Contextor.setContext(applicationContext)
    }

}
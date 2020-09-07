package com.example.kotlin_mvvm_clean_architecture_demo.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlin_mvvm_clean_architecture_demo.data.model.artist.Artist
import com.example.kotlin_mvvm_clean_architecture_demo.data.model.movie.Movie
import com.example.kotlin_mvvm_clean_architecture_demo.data.model.tvshow.TVShow

@Database(entities = [Movie::class, Artist::class, TVShow::class],version = 1, exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {

    abstract fun movieDAO(): MovieDAO
    abstract fun artistDAO(): ArtistDAO
    abstract fun tvShowDAO(): TVShowDAO

    companion object{

        const val DB_NAME = "TBDB_database"

        @Volatile
        private var INSTANCE : TMDBDatabase? = null
        fun getInstance(context: Context): TMDBDatabase {
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TMDBDatabase::class.java,
                        DB_NAME
                    ).build()
                }
                return instance
            }
        }

    }


}
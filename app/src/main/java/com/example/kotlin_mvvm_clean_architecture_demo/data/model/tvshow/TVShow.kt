package com.example.kotlin_mvvm_clean_architecture_demo.data.model.tvshow


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = TVShow.TABLE_NAME)
data class TVShow(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("overview")
    val overview: String,

    @SerializedName("poster_path")
    val posterPath: String
){
    companion object{
        const val TABLE_NAME: String = "popular_tv_show"
    }
}
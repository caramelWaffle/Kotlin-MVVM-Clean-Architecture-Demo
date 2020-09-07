package com.example.kotlin_mvvm_clean_architecture_demo.data.model.artist


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = Artist.TABLE_NAME)
data class Artist(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("popularity")
    val popularity: Double,

    @SerializedName("profile_path")
    val profilePath: String
){
    companion object{
        const val TABLE_NAME: String = "popular_artists"
    }
}
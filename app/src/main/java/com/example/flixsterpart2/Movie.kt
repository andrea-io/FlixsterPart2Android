package com.example.flixsterpart2
import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Movie(
    @SerialName("poster_path")
    val poster_path: String?,
    @SerialName("title")
    val title: String?,
    @SerialName("vote_average")
    val vote_average: Number?,
    @SerialName("overview")
    val description: String?,
) : java.io.Serializable {

}
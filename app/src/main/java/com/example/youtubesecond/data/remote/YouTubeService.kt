package com.example.youtubesecond.data.remote

import com.example.youtubesecond.data.model.MainResponseYoutube
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeService {

    @GET("videos")
    fun getPopularVideos(@Query("key") key:String,
    @Query("chart") chart:String
    ) : MainResponseYoutube
}
//https://www.googleapis.com/youtube/v3/videos?key=AIzaSyC8HaYLDmL2XdTobBMoml-qBBR3hgvFIWc
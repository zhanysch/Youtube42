package com.example.youtubesecond.data.remote

import com.example.youtubesecond.data.model.MainResponseYoutube
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeService {

    @GET("videos")
    suspend fun getPopularVideos(
        //@Query("key") key:String, ключ убираем так как с помошью interceptora, подставили ключ, в класс APiKeyInterceptor
        //там находится и ключ
    @Query("chart") chart:String
    ) : MainResponseYoutube
}
//https://www.googleapis.com/youtube/v3/videos?key=AIzaSyC8HaYLDmL2XdTobBMoml-qBBR3hgvFIWc
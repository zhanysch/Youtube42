package com.example.youtubesecond.data.remote

import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitBuilder {

    private var service : YouTubeService? = null

    fun getService(): YouTubeService? {
        if (service == null) service = buildRetrofit()
        return service
    }
    private fun buildRetrofit(): YouTubeService {
       return Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/youtube/v3/")
            .addConverterFactory(GsonConverterFactory.create())
           .client(getClient()) // добавлеям okHttpClient в Retrofit тоесть результат функц getClient
            .build()
            .create(YouTubeService:: class.java)
    }

    private fun getClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY // тупо для отображен в logcat
        }
       return OkHttpClient.Builder()
            .connectTimeout(5 , TimeUnit.SECONDS)  // на подключение 5 секунд
            .readTimeout(10 , TimeUnit.SECONDS)   //на скачивание данных
            .writeTimeout(10 , TimeUnit.SECONDS)  // на отправку данных
           .addInterceptor(loggingInterceptor) // тупо  для logcat
           .addInterceptor(ApiKeyInterceptor())  // интерцептор сам нужен модифицировать запросы
            .build()
    }
}
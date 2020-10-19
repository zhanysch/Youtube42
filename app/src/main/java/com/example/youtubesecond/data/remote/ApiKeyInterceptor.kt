package com.example.youtubesecond.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {  //интерцептор сам нужен модифицировать запросы
        val original = chain.request()
        val originalHttpUrl = original.url

        val url = originalHttpUrl.newBuilder()  // благодар интерцепт он хранится только тут , и нет необходим в каждые класы прописывать ключ
            .addQueryParameter("key","AIzaSyC8HaYLDmL2XdTobBMoml-qBBR3hgvFIWc")
            .build()

        val requestBuilder = original.newBuilder()
            .url(url).build()

        return chain.proceed(requestBuilder)
    }
}
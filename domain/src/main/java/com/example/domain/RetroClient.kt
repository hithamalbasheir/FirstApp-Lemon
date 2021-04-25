package com.example.domain

import com.example.firstapplemon.useCases.GetPosts
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetroClient {
    val BASE_URL = "https://jsonplaceholder.typicode.com/"
    val requestInterface = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build().create(GetPosts::class.java)

}
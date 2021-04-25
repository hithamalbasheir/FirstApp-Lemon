package com.example.firstapplemon.DI.Modules

import com.example.firstapplemon.Constants
import com.example.firstapplemon.useCases.GetPosts
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
object NetworkModule {
    @Provides
    @Reusable
    fun provideGetPost(retrofit: Retrofit): GetPosts{
        return retrofit.create(GetPosts::class.java)
    }
    @Provides
    @Reusable
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants().BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}
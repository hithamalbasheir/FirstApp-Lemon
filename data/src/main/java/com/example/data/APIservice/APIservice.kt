package com.example.data.APIservice

import com.example.data.models.PostData
import io.reactivex.Observable
import retrofit2.http.GET

interface APIservice {
    @GET("posts/")
    fun getPosts(): Observable<List<PostData>>
}
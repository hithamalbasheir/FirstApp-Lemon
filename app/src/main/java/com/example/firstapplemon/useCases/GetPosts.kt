package com.example.firstapplemon.useCases

import com.example.firstapplemon.Model.Post
import io.reactivex.Observable
import retrofit2.http.GET
import java.util.*

interface GetPosts{
    @GET("/posts")
    fun getPosts() : Observable<List<Post>>
}

package com.example.firstapplemon.data

import com.example.firstapplemon.domain.models.Post
import io.reactivex.Observable
import retrofit2.http.*

interface  PostsRetrofitService {


    @GET("/posts")
    fun getPosts() : Observable<List<Post>>

    @DELETE("/posts/{id}")
    fun deletePost(@Path("id")id: Int) : Observable<Void>

//    @POST("")
//    fun createPost(request: CreatePostUseCase.Request) : Observable<Post>
    @Headers("Content-Type: application/json")
    @PUT("/posts/{id}")
    fun updatePost(@Path("id")id: Int, @Body post: Post) : Observable<Post>


}
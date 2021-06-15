package com.example.firstapplemon.data

import com.example.firstapplemon.domain.models.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface  PostsRetrofitService {


    @GET("/posts")
    fun getPosts() : Observable<List<Post>>

//    @DELETE()
//    fun deletePost(request: DeletePostUseCase.Request) : Observable<Void>
//
//    @POST("")
//    fun createPost(request: CreatePostUseCase.Request) : Observable<Post>
//
//    fun updatePost(request: UpdatePostUseCase.Request) : Observable<Post>


}
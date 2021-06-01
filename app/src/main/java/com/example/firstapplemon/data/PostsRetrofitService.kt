package com.example.firstapplemon.data

import com.example.firstapplemon.domain.CreatePostUseCase
import com.example.firstapplemon.domain.DeletePostUseCase
import com.example.firstapplemon.domain.GetPostsUseCase
import com.example.firstapplemon.domain.UpdatePostUseCase
import com.example.firstapplemon.domain.models.Post
import io.reactivex.Observable
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST

interface  PostsRetrofitService {


    @GET("/posts")
    fun getPosts(request: GetPostsUseCase.Request) : Observable<List<Post>>

    @DELETE()
    fun deletePost(request: DeletePostUseCase.Request) : Observable<Void>

    @POST("")
    fun createPost(request: CreatePostUseCase.Request) : Observable<Post>

    fun updatePost(request: UpdatePostUseCase.Request) : Observable<Post>


}
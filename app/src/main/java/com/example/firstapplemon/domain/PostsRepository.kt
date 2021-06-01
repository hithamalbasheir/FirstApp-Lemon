package com.example.firstapplemon.domain

import com.example.firstapplemon.domain.models.Post
import io.reactivex.Observable

interface PostsRepository {
    fun getPosts(request: GetPostsUseCase.Request) : Observable<List<Post>>
    fun createPost(request: CreatePostUseCase.Request) : Observable<Post>
    fun deletePost(request: DeletePostUseCase.Request) : Observable<Void>
    fun updatePost(request: UpdatePostUseCase.Request) : Observable<Post>
}
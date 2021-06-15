package com.example.firstapplemon.data

import android.content.Context
import com.example.firstapplemon.domain.*
import com.example.firstapplemon.domain.models.Post
import io.reactivex.Observable

class PostsMemoryImpl(context: Context) : PostsRepository {

    private val posts = mutableListOf<Post>()

    override fun getPosts(request: GetPostsUseCase.Request): Observable<List<Post>> {
        return Observable.just(posts)
    }

    override fun createPost(request: CreatePostUseCase.Request): Observable<Post> {
        TODO()
    }

    override fun deletePost(request: DeletePostUseCase.Request): Observable<Void> {
       TODO()
    }
    override fun updatePost(request: UpdatePostUseCase.Request): Observable<Post> {
       TODO()
    }
}
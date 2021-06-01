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
        val post = Post(request.id,request.userId, request.title, request.body)
        posts.add(post)
        return Observable.just(post)
    }

    override fun deletePost(request: DeletePostUseCase.Request): Observable<Void> {
        val post = posts.firstOrNull { it.id == request.postId }
        if (post != null)
            posts.remove(post)
        return Observable.just<Void>(null)
    }
    override fun updatePost(request: UpdatePostUseCase.Request): Observable<Post> {
        val post = posts.firstOrNull { it.userId == request.id }
        post?.apply {
            this.title = request.title
        }
        return Observable.just(post)
    }
}
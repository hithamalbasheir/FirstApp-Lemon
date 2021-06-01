package com.example.firstapplemon.domain

import com.example.firstapplemon.domain.models.Post
import io.reactivex.Observable

class GetPostsUseCase(private val repository: PostsRepository) {

    fun execute(request: Request): Observable<List<Post>> {
        return repository.getPosts(request)

    }

    class Request
}
package com.example.firstapplemon.domain

import com.example.firstapplemon.domain.models.Post
import io.reactivex.Observable

class UpdatePostUseCase(private val repository: PostsRepository) {

    fun execute(request: Request): Observable<Post> {
        return repository.updatePost(request)
    }

    data class Request(
        val id: Int,
        val post: Post
    )
}
package com.example.firstapplemon.domain

import io.reactivex.Observable

class DeletePostUseCase(private val repository: PostsRepository) {

    fun execute(request: Request): Observable<Void> {
        return repository.deletePost(request)
    }

    class Request(val postId: Int)
}
package com.example.firstapplemon.domain

import com.example.firstapplemon.presentation.di.PerActivity
import io.reactivex.Observable
import javax.inject.Inject
@PerActivity
class DeletePostUseCase @Inject constructor(private val repository: PostsRepository) {

    fun execute(request: Request): Observable<Void> {
        return repository.deletePost(request)
    }

    class Request(val postId: Int)
}
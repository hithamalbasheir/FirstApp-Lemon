package com.example.firstapplemon.domain

import com.example.firstapplemon.domain.models.Post
import com.example.firstapplemon.presentation.di.PerActivity
import io.reactivex.Observable
import javax.inject.Inject
@PerActivity
class GetPostsUseCase @Inject constructor(private val repository: PostsRepository) {

    fun execute(request: Request): Observable<List<Post>> {
        return repository.getPosts(request)

    }

    class Request
}
package com.example.firstapplemon.domain


import com.example.firstapplemon.domain.models.Post
import io.reactivex.Observable
import java.io.Serializable

class CreatePostUseCase(private val repository: PostsRepository){

    fun execute(request: Request): Observable<Post> {
        return repository.createPost(request)
    }

    data class Request(
        val id: Int,
        val userId: Int,
        val title: String,
        val body: String
    ) : Serializable
}
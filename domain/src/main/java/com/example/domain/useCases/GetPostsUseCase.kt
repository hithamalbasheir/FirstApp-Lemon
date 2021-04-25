package com.example.domain.useCases

import com.example.domain.Model.Post
import com.example.domain.repository.RemoteRepo
import io.reactivex.Single
import javax.inject.Inject

class GetPostsUseCase:
    GetPosts<Post>{
    override fun execute(): Single<Post> {
        return
    }

}
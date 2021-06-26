package com.example.firstapplemon.data
import com.example.firstapplemon.domain.*
import com.example.firstapplemon.domain.models.Post
import io.reactivex.Observable

class PostsApiImpl(private val service: PostsRetrofitService) : PostsRepository {

    override fun getPosts(request: GetPostsUseCase.Request): Observable<List<Post>> {
       return service.getPosts()
    }

    override fun createPost(request: CreatePostUseCase.Request): Observable<Post> {
        return service.createPost(request.post)
    }

    override fun deletePost(request: DeletePostUseCase.Request): Observable<Void> {
        return service.deletePost(request.postId)
    }
    override fun updatePost(request: UpdatePostUseCase.Request): Observable<Post> {
        return service.updatePost(request.id,request.post)
    }
}
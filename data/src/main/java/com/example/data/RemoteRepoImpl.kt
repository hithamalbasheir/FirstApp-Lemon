 package com.example.data

import com.example.data.APIservice.APIservice
import com.example.data.mappers.PostMapper
import com.example.domain.Model.Post
import com.example.domain.repository.RemoteRepo
import io.reactivex.Observable
import java.lang.reflect.Array.get
import javax.inject.Inject

class RemoteRepoImpl @Inject constructor(
    private val apiService: APIservice,
    private val postMapper: dagger.Lazy<List<PostMapper>>): RemoteRepo{
    override fun getPosts(): Observable<List<Post>> {
        return apiService.getPosts()
            .map{
                postMapper.get().
            }
    }
}
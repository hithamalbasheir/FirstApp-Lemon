package com.example.data.mappers

import com.example.data.models.PostData
import com.example.domain.Model.Post
import javax.inject.Inject

class PostMapper @Inject constructor(){
    fun toPost(postDataModelServer: PostData): Post {
        return Post(
            postDataModelServer.userId?:0,
            postDataModelServer.title?:"",
            postDataModelServer.body?:""
        )
    }
}
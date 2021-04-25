package com.example.domain.repository

import com.example.domain.Model.Post
import io.reactivex.Observable

interface RemoteRepo {
    fun getPosts(): Observable<List<Post>>
}
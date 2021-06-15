package com.example.firstapplemon.presentation

import com.example.firstapplemon.domain.models.Post

interface PostsView {
    fun displayPosts(posts: List<Post>)
    fun showError(message: String?)
}
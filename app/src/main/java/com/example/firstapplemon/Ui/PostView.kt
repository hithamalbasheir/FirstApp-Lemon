package com.example.firstapplemon.Ui

import androidx.annotation.StringRes
import com.example.firstapplemon.Base.BaseView
import com.example.firstapplemon.Model.Post

interface PostView :BaseView{

    fun updatePosts(posts: List<Post>)

    fun showError(error: String)

    fun showError(@StringRes errorResId: Int) {
        this.showError(getContext().getString(errorResId))
    }
}
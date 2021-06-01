package com.example.firstapplemon.presentation.di

import com.example.firstapplemon.domain.PostsRepository
import com.example.firstapplemon.presentation.MainActivity
import dagger.Binds
import dagger.Component

@PerActivity
@Component(modules = [GetPostsModule::class])
interface GetPostsComponent {
    fun inject(activity: MainActivity)
    @Binds
    abstract fun getPostRepository(postsRepository: PostsRepository): PostsRepository
}
package com.example.firstapplemon.presentation.di

import com.example.firstapplemon.domain.PostsRepository
import com.example.firstapplemon.presentation.MainActivity
import dagger.BindsInstance
import dagger.Subcomponent

@PerActivity
@Subcomponent (modules = [GetPostsModule::class])
interface GetPostsComponent {
    fun inject(activity: MainActivity)
    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance postsRepository: PostsRepository): GetPostsComponent
    }

}
package com.example.firstapplemon.presentation.di

import com.example.firstapplemon.di.AppComponent
import com.example.firstapplemon.di.scopes.PerActivity
import com.example.firstapplemon.presentation.MainActivity
import dagger.Component

@PerActivity
@Component (modules = [GetPostsModule::class], dependencies = [AppComponent::class])
interface GetPostsComponent {
    fun inject(activity: MainActivity)
}
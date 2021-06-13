package com.example.firstapplemon.di

import com.example.firstapplemon.di.module.NetworkModule
import com.example.firstapplemon.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent{
    fun inject(mainActivity: MainActivity)
}
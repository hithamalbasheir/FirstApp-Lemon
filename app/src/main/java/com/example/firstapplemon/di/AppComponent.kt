package com.example.firstapplemon.di

import com.example.firstapplemon.MyApplication
import com.example.firstapplemon.di.module.NetworkModule
import com.example.firstapplemon.di.module.RxModule
import com.example.firstapplemon.di.scopes.IoScheduler
import com.example.firstapplemon.di.scopes.UIScheduler
import dagger.Component
import io.reactivex.Scheduler
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, RxModule::class])
interface AppComponent{
    fun inject(app: MyApplication)

    fun retrofit() : Retrofit

    @IoScheduler
    fun io() : Scheduler

    @UIScheduler
    fun ui() : Scheduler
}
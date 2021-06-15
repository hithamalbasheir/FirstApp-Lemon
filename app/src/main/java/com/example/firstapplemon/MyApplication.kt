package com.example.firstapplemon

import android.app.Application
import com.example.firstapplemon.di.AppComponent
import com.example.firstapplemon.di.DaggerAppComponent
import com.example.firstapplemon.di.module.NetworkModule
import com.example.firstapplemon.di.module.RxModule

class MyApplication : Application() {
    private lateinit var component: AppComponent
    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
                .networkModule(NetworkModule())
                .rxModule(RxModule())
                .build()
        component.inject(this)
    }

    fun getAppComponent() : AppComponent = component
}
package com.example.firstapplemon.DI

import android.app.Application

class MainApplication: Application() {
    lateinit var appcomponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
    }

}
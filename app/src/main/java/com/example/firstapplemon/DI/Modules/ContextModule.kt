package com.example.firstapplemon.DI.Modules

import android.app.Application
import android.content.Context
import com.example.firstapplemon.Base.BaseView
import dagger.Module
import dagger.Provides

@Module
object ContextModule {
    @Provides
    fun provideContext(baseView: BaseView): Context {
        return baseView.getContext()
    }
    @Provides
    fun provideApplication(context: Context): Application {
        return context.applicationContext as Application
    }
}
package com.example.firstapplemon.di.module

import com.example.firstapplemon.di.scopes.IoScheduler
import com.example.firstapplemon.di.scopes.UIScheduler
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Module
class RxModule {

    @Singleton
    @IoScheduler
    @Provides
    fun provideIoScheduler() : Scheduler {
        return Schedulers.io()
    }

    @Singleton
    @UIScheduler
    @Provides
    fun provideUIScheduler() : Scheduler {
        return AndroidSchedulers.mainThread()
    }

}
package com.example.firstapplemon.di

import com.example.firstapplemon.presentation.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector
@Subcomponent
interface MainActivityComponent : AndroidInjector<MainActivity> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<MainActivity>
}
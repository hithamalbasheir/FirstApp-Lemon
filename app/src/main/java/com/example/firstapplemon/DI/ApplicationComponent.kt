package com.example.firstapplemon.DI

import com.example.firstapplemon.Base.BaseView
import com.example.firstapplemon.Ui.MainActivity
import com.example.firstapplemon.DI.Modules.ContextModule
import com.example.firstapplemon.DI.Modules.NetworkModule
import com.example.firstapplemon.Ui.PostsPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (modules = [(NetworkModule::class),(ContextModule::class)])
interface ApplicationComponent {
    fun inject(postsPresenter: PostsPresenter)
    @Component.Builder
    interface Builder{
        fun build(): ApplicationComponent
        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder
        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}
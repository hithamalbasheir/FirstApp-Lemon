package com.example.firstapplemon.Base

import com.example.firstapplemon.DI.ApplicationComponent
import com.example.firstapplemon.DI.DaggerApplicationComponent
import com.example.firstapplemon.DI.Modules.ContextModule
import com.example.firstapplemon.DI.Modules.NetworkModule
import com.example.firstapplemon.Ui.PostsPresenter

abstract class BasePresenter<out baseView:BaseView>(protected val view:baseView){
    private val injector: ApplicationComponent= DaggerApplicationComponent
        .builder()
        .baseView(view)
        .contextModule(ContextModule)
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    open fun onViewCreated(){}

    open fun onViewDestroyed(){}

    private fun inject() {
        when (this) {
            is PostsPresenter -> injector.inject(this)
        }
    }
}
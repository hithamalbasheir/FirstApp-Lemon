package com.example.firstapplemon.Base

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<basePresenter: BasePresenter<BaseView>> : BaseView, AppCompatActivity() {
    protected lateinit var presenter: basePresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = instantiatePresenter()
    }

    protected abstract fun instantiatePresenter(): basePresenter
    override fun getContext(): Context {
        return this
    }

}
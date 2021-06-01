package com.example.firstapplemon.presentation

import com.example.firstapplemon.domain.CreatePostUseCase
import com.example.firstapplemon.domain.DeletePostUseCase
import com.example.firstapplemon.domain.GetPostsUseCase
import com.example.firstapplemon.domain.UpdatePostUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PostsPresenter (
        private val getPostsUseCase: GetPostsUseCase,
        val createPostUseCase: CreatePostUseCase,
        val updatePostUseCase: UpdatePostUseCase,
        val deletePostUseCase: DeletePostUseCase
){

    private val compositeDisposable = CompositeDisposable()

    fun getPosts() {
        val subscription = getPostsUseCase.execute(GetPostsUseCase.Request())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
            }, {

            })
        compositeDisposable.add(subscription)
    }


    fun onDestroy(){
        compositeDisposable.clear()
    }

}
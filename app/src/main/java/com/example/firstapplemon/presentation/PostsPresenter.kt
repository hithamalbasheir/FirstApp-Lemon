package com.example.firstapplemon.presentation

import com.example.firstapplemon.domain.CreatePostUseCase
import com.example.firstapplemon.domain.DeletePostUseCase
import com.example.firstapplemon.domain.GetPostsUseCase
import com.example.firstapplemon.domain.UpdatePostUseCase
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
class PostsPresenter (
        private val getPostsUseCase: GetPostsUseCase,
        val createPostUseCase: CreatePostUseCase,
        val updatePostUseCase: UpdatePostUseCase,
        val deletePostUseCase: DeletePostUseCase,
        val ioScheduler: Scheduler,
        val uiScheduler: Scheduler
){

    private val compositeDisposable = CompositeDisposable()
    private var view: PostsView? = null

    fun attachView(view: PostsView){
        this.view = view
    }

    fun getPosts() {
        val subscription = getPostsUseCase.execute(GetPostsUseCase.Request())
            .subscribeOn(ioScheduler)
            .observeOn(uiScheduler)
            .subscribe({
                     view?.displayPosts(it!!)
            }, {
                it.printStackTrace()
                view?.showError(it.message)
            })
        compositeDisposable.add(subscription)
    }

    fun onDestroy(){
        compositeDisposable.clear()
        view=null
    }

}
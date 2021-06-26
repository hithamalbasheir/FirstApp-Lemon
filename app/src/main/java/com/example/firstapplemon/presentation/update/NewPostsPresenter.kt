package com.example.firstapplemon.presentation.update

import com.example.firstapplemon.domain.CreatePostUseCase
import com.example.firstapplemon.domain.UpdatePostUseCase
import com.example.firstapplemon.domain.models.Post
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable

class NewPostsPresenter(
        val updatePostUseCase: UpdatePostUseCase,
        val createPostUseCase: CreatePostUseCase,
        val ioScheduler: Scheduler,
        val uiScheduler: Scheduler
) {
    private var view: NewPostView? = null
    private val compositeDisposable = CompositeDisposable()
    fun attachView(view: NewPostView){
        this.view = view
    }

    fun onUpdate(post: Post){
        val subscription = updatePostUseCase.execute(UpdatePostUseCase.Request(post.id,post))
                .subscribeOn(ioScheduler)
                .observeOn(uiScheduler)
                .subscribe ({
                    view?.updatedSuccessfully()
                }, {
                    it.printStackTrace()
                    view?.showError(it.message)
                }
                )
        compositeDisposable.add(subscription)

    }
    fun onDestroy(){
        compositeDisposable.clear()
        view=null
    }

    fun onCreate(post: Post) {
        val subscription = createPostUseCase.execute(CreatePostUseCase.Request(post))
            .subscribeOn(ioScheduler)
            .observeOn(uiScheduler)
            .subscribe({
                view?.createdSuccessfully()
            },{
                it.printStackTrace()
                view?.showError(it.message)
            })
        compositeDisposable.add(subscription)
    }
}
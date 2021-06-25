package com.example.firstapplemon.presentation.update

import com.example.firstapplemon.domain.UpdatePostUseCase
import com.example.firstapplemon.domain.models.Post
import io.reactivex.Scheduler

class NewPostsPresenter(
        val updatePostUseCase: UpdatePostUseCase,
        val ioScheduler: Scheduler,
        val uiScheduler: Scheduler
) {
    private var view: NewPostView? = null
    fun attachView(view: NewPostView){
        this.view = view
    }

    fun onUpdate(post: Post){
        var subscription = updatePostUseCase.execute(UpdatePostUseCase.Request(post.id,post))
                .subscribeOn(ioScheduler)
                .observeOn(uiScheduler)
                .subscribe ({
                    view?.updatedSuccessfully()
                }, {
                    it.printStackTrace()
                    view?.showError(it.message)
                }
                )

    }
}
package com.example.firstapplemon.Ui

import com.example.firstapplemon.Base.BasePresenter
import com.example.firstapplemon.R
import com.example.firstapplemon.useCases.GetPosts
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class PostsPresenter(postView: PostView): BasePresenter<PostView>(postView) {
    @Inject
    lateinit var getPosts: GetPosts
    private var subscription: Disposable? = null
    override fun onViewCreated() {
        loadPosts()
    }
    fun loadPosts() {
        subscription = getPosts
            .getPosts()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { postList -> view.updatePosts(postList) },
                { view.showError(R.string.unknown_error) }
            )
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }

}
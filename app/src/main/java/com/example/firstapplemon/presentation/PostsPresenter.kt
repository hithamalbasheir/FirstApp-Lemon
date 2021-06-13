package com.example.firstapplemon.presentation

import com.example.firstapplemon.domain.CreatePostUseCase
import com.example.firstapplemon.domain.DeletePostUseCase
import com.example.firstapplemon.domain.GetPostsUseCase
import com.example.firstapplemon.domain.UpdatePostUseCase
import com.example.firstapplemon.presentation.di.PerActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
@PerActivity
class PostsPresenter @Inject constructor (
        private val getPostsUseCase: GetPostsUseCase,
        val createPostUseCase: CreatePostUseCase,
        val updatePostUseCase: UpdatePostUseCase,
        val deletePostUseCase: DeletePostUseCase
){

    private val compositeDisposable = CompositeDisposable()
//    private val compositeDisposable : CompositeDisposable? = null
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
package com.example.domain.useCases

import io.reactivex.Single

interface GetPosts<R>{
    fun execute() : Single<R>
}

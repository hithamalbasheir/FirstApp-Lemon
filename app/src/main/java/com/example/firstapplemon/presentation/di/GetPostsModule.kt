package com.example.firstapplemon.presentation.di

import com.example.firstapplemon.data.PostsApiImpl
import com.example.firstapplemon.data.PostsRetrofitService
import com.example.firstapplemon.di.scopes.IoScheduler
import com.example.firstapplemon.di.scopes.PerActivity
import com.example.firstapplemon.di.scopes.UIScheduler
import com.example.firstapplemon.domain.*
import com.example.firstapplemon.presentation.PostsPresenter
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import retrofit2.Retrofit

@Module
class GetPostsModule {
    @PerActivity
    @Provides
    fun providePostsRetrofitService (retrofit: Retrofit) : PostsRetrofitService {
        return retrofit.create(PostsRetrofitService::class.java)
    }

    @PerActivity
    @Provides
    fun providePostsRepository(service: PostsRetrofitService) : PostsRepository {
        return PostsApiImpl(service)
    }

    @PerActivity
    @Provides
    fun provideGetPostsUseCase(postsRepository: PostsRepository) : GetPostsUseCase {
        return GetPostsUseCase(postsRepository)
    }

    @PerActivity
    @Provides
    fun provideCreatePostUseCase(postsRepository: PostsRepository) : CreatePostUseCase {
        return CreatePostUseCase(postsRepository)
    }

    @PerActivity
    @Provides
    fun provideUpdatePostUseCase(postsRepository: PostsRepository) : UpdatePostUseCase {
        return UpdatePostUseCase(postsRepository)
    }

    @PerActivity
    @Provides
    fun provideDeletePostUseCase(postsRepository: PostsRepository) : DeletePostUseCase {
        return DeletePostUseCase(postsRepository)
    }

    @PerActivity
    @Provides
    fun providePostsPresenter(
        getPostsUseCase: GetPostsUseCase,
        createPostUseCase: CreatePostUseCase,
        updatePostUseCase: UpdatePostUseCase,
        deletePostUseCase: DeletePostUseCase,
        @IoScheduler  ioScheduler: Scheduler,
       @UIScheduler uiScheduler: Scheduler
    ): PostsPresenter {
        return PostsPresenter(
            getPostsUseCase,
            createPostUseCase,
            updatePostUseCase,
            deletePostUseCase,ioScheduler,uiScheduler
        )
    }

}
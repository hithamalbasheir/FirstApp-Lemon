package com.example.firstapplemon.presentation.di

import com.example.firstapplemon.data.PostsRetrofitService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
abstract class GetPostsModule {
    @PerActivity
    @Provides
    fun providePostsRetrofitService (retrofit: Retrofit) : PostsRetrofitService {
        return retrofit.create(PostsRetrofitService::class.java)
    }

//    @PerActivity
//    @Provides
//    fun providePostsRepository(service: PostsRetrofitService) : PostsRepository {
//        return PostsApiImpl(service)
//    }

//    @PerActivity
//    @Provides
//    fun provideGetPostsUseCase(postsRepository: PostsRepository) : GetPostsUseCase {
//        return GetPostsUseCase(postsRepository)
//    }

//    @PerActivity
//    @Provides
//    fun provideCreatePostUseCase(postsRepository: PostsRepository) : CreatePostUseCase {
//        return CreatePostUseCase(postsRepository)
//    }

//    @PerActivity
//    @Provides
//    fun provideUpdatePostUseCase(postsRepository: PostsRepository) : UpdatePostUseCase {
//        return UpdatePostUseCase(postsRepository)
//    }

//    @PerActivity
//    @Provides
//    fun provideDeletePostUseCase(postsRepository: PostsRepository) : DeletePostUseCase {
//        return DeletePostUseCase(postsRepository)
//    }

//    @PerActivity
//    @Provides
//    fun providePostsPresenter(
//        getPostsUseCase: GetPostsUseCase,
//        createPostUseCase: CreatePostUseCase,
//        updatePostUseCase: UpdatePostUseCase,
//        deletePostUseCase: DeletePostUseCase
//    ): PostsPresenter {
//        return PostsPresenter(
//            getPostsUseCase,
//            createPostUseCase,
//            updatePostUseCase,
//            deletePostUseCase
//        )
//    }

}
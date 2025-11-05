package com.towitty.data.di

import com.towitty.data.usecase.main.writing.GetLocalImageListUseCaseImpl
import com.towitty.data.usecase.main.writing.PostBoardUseCaseImpl
import com.towitty.domain.usecase.main.writing.GetImageListUseCase
import com.towitty.domain.usecase.main.writing.PostBoardUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class WritingModule {

    @Binds
    abstract fun bindGetImageListUseCase(
        getLocalImageListUseCaseImpl: GetLocalImageListUseCaseImpl
    ): GetImageListUseCase

    @Binds
    abstract fun bindPostBoardUseCase(
        postBoardUseCaseImpl: PostBoardUseCaseImpl
    ): PostBoardUseCase
}
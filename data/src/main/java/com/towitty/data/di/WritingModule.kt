package com.towitty.data.di

import com.towitty.data.usecase.main.writing.GetLocalImageListUseCaseImpl
import com.towitty.domain.usecase.main.writing.GetImageListUseCase
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
}
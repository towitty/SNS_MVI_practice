package com.towitty.data.di

import com.towitty.data.usecase.file.GetImageUseCaseImpl
import com.towitty.data.usecase.file.GetInputStreamUseCaseImpl
import com.towitty.data.usecase.file.UploadImageUseCaseImpl
import com.towitty.domain.usecase.file.GetImageUseCase
import com.towitty.domain.usecase.file.GetInputStreamUseCase
import com.towitty.domain.usecase.file.UploadImageUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FileModule {

    @Binds
    abstract fun bindGetInputStreamUseCase(getInputStreamUseCaseImpl: GetInputStreamUseCaseImpl): GetInputStreamUseCase

    @Binds
    abstract fun bindGetImageUseCaseImpl(getImageUseCaseImpl: GetImageUseCaseImpl): GetImageUseCase

    @Binds
    abstract fun bindUploadImageUseCase(uploadImageUseCaseImpl: UploadImageUseCaseImpl): UploadImageUseCase

}
package com.towitty.data.di

import com.towitty.data.usecase.LoginUseCaseImpl
import com.towitty.domain.usecase.login.LoginUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UserModule {

    @Binds
    abstract fun bindLoginUseCase(useCaseImpl: LoginUseCaseImpl): LoginUseCase
}
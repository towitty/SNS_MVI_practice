package com.towitty.data.di

import com.towitty.data.usecase.LoginUseCaseImpl
import com.towitty.data.usecase.SignUpUseCaseImpl
import com.towitty.domain.usecase.login.LoginUseCase
import com.towitty.domain.usecase.login.SignUpUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UserModule {

    @Binds
    abstract fun bindLoginUseCase(useCaseImpl: LoginUseCaseImpl): LoginUseCase

    @Binds
    abstract fun bindSignUpUseCase(signUpUseCaseImpl: SignUpUseCaseImpl): SignUpUseCase
}
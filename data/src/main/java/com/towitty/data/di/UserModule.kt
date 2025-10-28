package com.towitty.data.di

import com.towitty.data.usecase.ClearTokenUseCaseImpl
import com.towitty.data.usecase.GetTokenUseCaseImpl
import com.towitty.data.usecase.LoginUseCaseImpl
import com.towitty.data.usecase.SetTokenUseCaseImpl
import com.towitty.data.usecase.SignUpUseCaseImpl
import com.towitty.data.usecase.main.setting.GetMyUseCaseImpl
import com.towitty.domain.usecase.login.ClearTokenUseCase
import com.towitty.domain.usecase.login.GetTokenUseCase
import com.towitty.domain.usecase.login.LoginUseCase
import com.towitty.domain.usecase.login.SetTokenUseCase
import com.towitty.domain.usecase.login.SignUpUseCase
import com.towitty.domain.usecase.main.setting.GetMyUserUseCase
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

    @Binds
    abstract fun bindGetTokenUseCase(getTokenUseCase: GetTokenUseCaseImpl): GetTokenUseCase

    @Binds
    abstract fun bindSetTokenUseCase(setTokenUseCase: SetTokenUseCaseImpl): SetTokenUseCase

    @Binds
    abstract fun bindClearTokenUseCase(clearTokenUseCase: ClearTokenUseCaseImpl): ClearTokenUseCase

    @Binds
    abstract fun bindGetMyUserUseCase(getMyUserUseCaseImpl: GetMyUseCaseImpl): GetMyUserUseCase
}
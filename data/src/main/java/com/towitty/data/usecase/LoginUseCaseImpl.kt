package com.towitty.data.usecase

import com.towitty.domain.usecase.login.LoginUseCase
import javax.inject.Inject

class LoginUseCaseImpl @Inject constructor() : LoginUseCase {
    override suspend fun invoke(
        id: String,
        password: String
    ): Result<Unit> = kotlin.runCatching {
        "token"
    }
}
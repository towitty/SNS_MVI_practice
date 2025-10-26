package com.towitty.data.usecase

import com.towitty.data.model.LoginParam
import com.towitty.data.retrofit.UserService
import com.towitty.domain.usecase.login.LoginUseCase
import javax.inject.Inject

class LoginUseCaseImpl @Inject constructor(
    private val userService: UserService
) : LoginUseCase {
    override suspend fun invoke(
        id: String,
        password: String
    ): Result<String> = kotlin.runCatching {
        val requestBody = LoginParam(loginId = id, password = password).toRequestBody()
        userService.login(requestBody = requestBody).data
    }
}
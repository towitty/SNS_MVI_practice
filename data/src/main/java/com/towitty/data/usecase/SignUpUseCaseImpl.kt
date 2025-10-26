package com.towitty.data.usecase

import com.towitty.data.model.SignUpParam
import com.towitty.data.retrofit.UserService
import com.towitty.domain.usecase.login.SignUpUseCase
import javax.inject.Inject

class SignUpUseCaseImpl @Inject constructor(
    private val userService: UserService
) : SignUpUseCase {
    override suspend fun invoke(
        id: String,
        username: String,
        password: String
    ): Result<Boolean> = runCatching {
        val requestBody = SignUpParam(
            loginId = id,
            name = username,
            password = password,
            extraUserInfo = "",
            profileFilePath = ""

        ).toRequestBody()
        userService.signUp(requestBody = requestBody).result == "SUCCESS"
    }
}
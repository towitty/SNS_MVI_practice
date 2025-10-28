package com.towitty.data.usecase.main.setting

import com.towitty.data.model.toDomainModel
import com.towitty.data.retrofit.UserService
import com.towitty.domain.model.User
import com.towitty.domain.usecase.main.setting.GetMyUserUseCase
import javax.inject.Inject

class GetMyUseCaseImpl @Inject constructor(
    private val userService: UserService
) : GetMyUserUseCase {

    override suspend fun invoke(): Result<User> = kotlin.runCatching {
        userService.myPage().data.toDomainModel()
    }
}
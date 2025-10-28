package com.towitty.domain.usecase.main.setting

import com.towitty.domain.model.User

interface GetMyUserUseCase {

    suspend operator fun invoke(): Result<User>
}
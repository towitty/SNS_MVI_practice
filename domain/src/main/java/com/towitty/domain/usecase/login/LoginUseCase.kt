package com.towitty.domain.usecase.login

interface LoginUseCase {

    suspend operator fun invoke(username: String, password: String): Result<Unit>
}
package com.towitty.domain.usecase.login

interface GetTokenUseCase {

    suspend operator fun invoke(): String?
}
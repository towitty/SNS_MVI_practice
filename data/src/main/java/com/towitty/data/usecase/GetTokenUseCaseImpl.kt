package com.towitty.data.usecase

import com.towitty.data.UserDataStore
import com.towitty.domain.usecase.login.GetTokenUseCase
import javax.inject.Inject

class GetTokenUseCaseImpl @Inject constructor(
    private val userDataStore: UserDataStore
) : GetTokenUseCase {
    override suspend fun invoke(): String? {
        return userDataStore.getToken()
    }
}
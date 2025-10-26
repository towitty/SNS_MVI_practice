package com.towitty.data.usecase

import com.towitty.data.UserDataStore
import com.towitty.domain.usecase.login.ClearTokenUseCase
import javax.inject.Inject

class ClearTokenUseCaseImpl @Inject constructor(
    private val userDataStore: UserDataStore
) : ClearTokenUseCase {
    override suspend fun invoke() {
        return userDataStore.clearToken()
    }
}
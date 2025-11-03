package com.towitty.data.usecase.main.setting

import com.towitty.data.model.UpdateMyInfoParam
import com.towitty.data.retrofit.UserService
import com.towitty.domain.usecase.main.setting.GetMyUserUseCase
import com.towitty.domain.usecase.main.setting.SetMyUserUseCase
import javax.inject.Inject

class SetMyUserUseCaseImpl @Inject constructor(
    private val userService: UserService,
    private val getMyUserUseCase: GetMyUserUseCase
) : SetMyUserUseCase {
    override suspend fun invoke(
        username: String?,
        profileImageUrl:String?
    ): Result<Unit> = kotlin.runCatching{
        val user = getMyUserUseCase().getOrThrow()
        val requestBody = UpdateMyInfoParam(
            userName = username ?: user.username,
            profileFilePath = profileImageUrl ?: user.profileImageUrl.orEmpty(),
            extraUserInfo = ""
        ).toRequestBody()
        userService.patchMyPage(requestBody)
    }
}
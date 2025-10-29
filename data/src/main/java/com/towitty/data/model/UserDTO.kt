package com.towitty.data.model

import com.towitty.domain.model.User
import kotlinx.serialization.Serializable

@Serializable
data class UserDTO(
    val id: Long,
    val loginId: String,
    val userName: String,
    val extraUserInfo: String,
    val profileFilePath: String
)

fun UserDTO.toDomainModel(): User {
    return User(
        id = this.id,
        loginId = this.loginId,
        username = this.userName,
        profileImageUrl = this.profileFilePath
    )
}

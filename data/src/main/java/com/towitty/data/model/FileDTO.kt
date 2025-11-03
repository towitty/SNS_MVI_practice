package com.towitty.data.model

import kotlinx.serialization.Serializable

@Serializable
data class FileDTO(
    val id: Long,
    val fileName: String,
    val createAt: String,
    val filePath: String
)

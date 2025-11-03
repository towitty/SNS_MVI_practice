package com.towitty.domain.usecase.file

import com.towitty.domain.model.Image

interface UploadImageUseCase {

    suspend operator fun invoke(image: Image): Result<String>
}
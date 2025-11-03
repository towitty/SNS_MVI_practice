package com.towitty.domain.usecase.file

import com.towitty.domain.model.Image

interface GetImageUseCase {

    operator fun invoke(contentUri: String): Image?
}
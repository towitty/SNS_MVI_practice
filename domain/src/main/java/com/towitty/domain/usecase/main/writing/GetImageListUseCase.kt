package com.towitty.domain.usecase.main.writing

import com.towitty.domain.model.Image

interface GetImageListUseCase {

    suspend operator fun invoke(): List<Image>
}
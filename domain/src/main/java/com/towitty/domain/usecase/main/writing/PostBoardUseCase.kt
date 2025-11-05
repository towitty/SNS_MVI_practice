package com.towitty.domain.usecase.main.writing

import com.towitty.domain.model.Image

interface PostBoardUseCase {

    suspend operator fun invoke(
        title: String,
        content: String,
        images: List<Image>
    )
}
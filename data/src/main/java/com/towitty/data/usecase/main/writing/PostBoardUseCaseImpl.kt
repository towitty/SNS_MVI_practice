package com.towitty.data.usecase.main.writing

import android.content.Context
import android.content.Intent
import com.towitty.data.model.BoardParcel
import com.towitty.data.service.PostingService
import com.towitty.domain.model.Image
import com.towitty.domain.usecase.main.writing.PostBoardUseCase
import javax.inject.Inject

class PostBoardUseCaseImpl @Inject constructor(
    private val context: Context
) : PostBoardUseCase {
    override suspend fun invoke(
        title: String,
        content: String,
        images: List<Image>
    ) {
        val board = BoardParcel(title = title, content = content, images = images)
        Intent(
            context,
            PostingService::class.java
        ).apply {
            putExtra(PostingService.EXTRA_BOARD, board)
        }
    }
}
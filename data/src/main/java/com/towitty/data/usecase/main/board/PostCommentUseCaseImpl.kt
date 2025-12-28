package com.towitty.data.usecase.main.board

import com.towitty.data.model.CommentParam
import com.towitty.data.retrofit.BoardService
import com.towitty.domain.usecase.main.board.PostCommentUseCase
import javax.inject.Inject

class PostCommentUseCaseImpl @Inject constructor(
    private val boardService: BoardService
) : PostCommentUseCase {
    override suspend fun invoke(
        boardId: Long,
        text: String
    ): Result<Long> = runCatching {
        val requestBody = CommentParam(text).toRequestBody()
        boardService.postComment(
            boardId = boardId,
            requestBody = requestBody
        ).data
    }
}
package com.towitty.data.usecase.main.board

import com.towitty.data.retrofit.BoardService
import com.towitty.domain.usecase.main.board.DeleteCommentUseCase
import javax.inject.Inject

class DeleteCommentUseCaseImpl @Inject constructor(
    private val boardService: BoardService
) : DeleteCommentUseCase {
    override suspend fun invoke(
        boardId: Long,
        commentId: Long
    ): Result<Long> = runCatching {
        boardService.deleteComment(
            boardId = boardId, commentId = commentId
        ).data
    }
}
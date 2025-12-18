package com.towitty.data.usecase.main

import com.towitty.data.retrofit.BoardService
import com.towitty.domain.usecase.main.board.DeleteBoardUseCase
import javax.inject.Inject

class DeleteBoardUseCaseImpl @Inject constructor(
    private val boardService: BoardService
) : DeleteBoardUseCase {
    override suspend fun invoke(boardId: Long): Result<Long> = runCatching {
        boardService.deleteBoard(boardId).data
    }
}
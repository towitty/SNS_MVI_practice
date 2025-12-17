package com.towitty.domain.usecase.main.board

import androidx.paging.PagingData
import com.towitty.domain.model.Board
import kotlinx.coroutines.flow.Flow

interface GetBoardsUseCase {

    suspend operator fun invoke(): Result<Flow<PagingData<Board>>>
}
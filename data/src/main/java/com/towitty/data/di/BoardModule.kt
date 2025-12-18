package com.towitty.data.di

import com.towitty.data.usecase.main.DeleteBoardUseCaseImpl
import com.towitty.data.usecase.main.board.GetBoardsUseCaseImpl
import com.towitty.domain.usecase.main.board.DeleteBoardUseCase
import com.towitty.domain.usecase.main.board.GetBoardsUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class BoardModule {

    @Binds
    abstract fun bindGetBoardsUseCase(getBoardsUseCaseImpl: GetBoardsUseCaseImpl): GetBoardsUseCase

    @Binds
    abstract fun bindDeleteBoardUseCase(deleteBoardUseCaseImpl: DeleteBoardUseCaseImpl): DeleteBoardUseCase

}
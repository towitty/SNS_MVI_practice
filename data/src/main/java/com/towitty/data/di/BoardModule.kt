package com.towitty.data.di

import com.towitty.data.usecase.main.DeleteBoardUseCaseImpl
import com.towitty.data.usecase.main.board.DeleteCommentUseCaseImpl
import com.towitty.data.usecase.main.board.GetBoardsUseCaseImpl
import com.towitty.data.usecase.main.board.PostCommentUseCaseImpl
import com.towitty.domain.usecase.main.board.DeleteBoardUseCase
import com.towitty.domain.usecase.main.board.DeleteCommentUseCase
import com.towitty.domain.usecase.main.board.GetBoardsUseCase
import com.towitty.domain.usecase.main.board.PostCommentUseCase
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

    @Binds
    abstract fun bindPostCommentUseCase(postCommentUseCaseImpl: PostCommentUseCaseImpl): PostCommentUseCase

    @Binds
    abstract fun bindDeleteCommentUseCase(deleteCommentUseCaseImpl: DeleteCommentUseCaseImpl): DeleteCommentUseCase

}
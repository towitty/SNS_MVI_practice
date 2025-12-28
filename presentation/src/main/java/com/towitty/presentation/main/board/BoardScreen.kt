package com.towitty.presentation.main.board

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.towitty.domain.model.Comment
import com.towitty.presentation.model.main.board.BoardCardModel
import com.towitty.presentation.theme.SNSTheme
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun BoardScreen(
    viewModel: BoardViewModel = hiltViewModel()
) {

    val state = viewModel.collectAsState().value
    var modelForDialog: BoardCardModel? by remember { mutableStateOf(null) }
    val context = LocalContext.current

    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            is BoardSideEffect.Toast -> {
                Toast.makeText(context, sideEffect.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    BoardScreen(
        myUserId = state.myUserId,
        boardCardModels = state.boardCardModelFlow.collectAsLazyPagingItems(),
        deletedBoardIds = state.deletedBoardIds,
        addedComments = state.addedComments,
        deletedComments = state.deletedComments,
        onOptionClick = { modelForDialog = it },
        onDeleteComment = viewModel::onDeleteComment,
        onCommentSend = viewModel::onCommentSend,
    )

    BoardOptionDialog(
        model = modelForDialog,
        onDismissRequest = { modelForDialog = null },
        onBoardDelete = viewModel::onBoardDelete
    )
}

@Composable
private fun BoardScreen(
    myUserId: Long,
    boardCardModels: LazyPagingItems<BoardCardModel>,
    deletedBoardIds: Set<Long> = emptySet(),
    addedComments: Map<Long, List<Comment>>,
    deletedComments: Map<Long, List<Comment>>,
    onOptionClick: (BoardCardModel) -> Unit,
    onDeleteComment: (Long, Comment) -> Unit,
    onCommentSend: (Long, String) -> Unit
) {
    Surface {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(
                count = boardCardModels.itemCount,
                key = { index -> boardCardModels[index]?.boardId ?: index }
            ) { index ->
                boardCardModels[index]?.run {
                    val model = this
                    if (!deletedBoardIds.contains(model.boardId))
                        BoardCard(
                            isMine = model.userId == myUserId,
                            boardId = model.boardId,
                            username = model.username,
                            images = model.images,
                            text = model.text,
                            comments = model.comments + addedComments[boardId].orEmpty() - deletedComments[boardId].orEmpty(),
                            onOptionClick = { onOptionClick(model) },
                            onDeleteComment = onDeleteComment,
                            onCommentSend = onCommentSend
                        )
                }
            }
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun BoardScreenPreview() {
    SNSTheme {
//        BoardScreen(
//            boardCardModels = listOf(
//                BoardCardModel(
//                    boardId = 1,
//                    username = "Charles",
//                    images = listOf(),
//                    text = "내용1"
//                ),
//                BoardCardModel(
//                    boardId = 2,
//                    username = "Fast Campus",
//                    images = listOf(),
//                    text = "내용2"
//                ),
//                BoardCardModel(
//                    boardId = 3,
//                    username = "Hung Bennett",
//                    images = listOf(),
//                    text = "내용3"
//                )
//            ),
//            onOptionClick = {},
//            onReplyClick = {}
//        )
    }
}
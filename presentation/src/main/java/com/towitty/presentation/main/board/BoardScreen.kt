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
        boardCardModels = state.boardCardModelFlow.collectAsLazyPagingItems(),
        onOptionClick = { modelForDialog = it },
        onDeleteComment = viewModel::onDeleteComment
    )

    BoardOptionDialog(
        model = modelForDialog,
        onDismissRequest = { modelForDialog = null },
        onBoardDelete = viewModel::onBoardDelete
    )
}

@Composable
private fun BoardScreen(
    boardCardModels: LazyPagingItems<BoardCardModel>,
    deletedBoardIds: Set<Long> = emptySet(),
    onOptionClick: (BoardCardModel) -> Unit,
    onDeleteComment: (Comment) -> Unit
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
                    if (!deletedBoardIds.contains(this.boardId))
                        BoardCard(
                            username = this.username,
                            images = this.images,
                            text = this.text,
                            comments = this.comments,
                            onOptionClick = { onOptionClick(this) },
                            onDeleteComment = onDeleteComment
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
package com.towitty.presentation.main.board

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.towitty.presentation.model.main.board.BoardCardModel
import com.towitty.presentation.theme.SNSTheme

@Composable
fun BoardScreen(
    boardCardModels: List<BoardCardModel>,
    onOptionClick: () -> Unit,
    onReplyClick: () -> Unit
) {
    Surface {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(
                count = boardCardModels.size,
                key = { index -> boardCardModels[index].boardId }
            ) { index ->
                val boardCardModel = boardCardModels[index]
                BoardCard(
                    username = boardCardModel.username,
                    images = boardCardModel.images,
                    text = boardCardModel.text,
                    onOptionClick = onOptionClick,
                    onReplyClick = onReplyClick
                )
            }
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun BoardScreenPreview() {
    SNSTheme {
        BoardScreen(
            boardCardModels = listOf(
                BoardCardModel(
                    boardId = 1,
                    username = "Charles",
                    images = listOf(),
                    text = "내용1"
                ),
                BoardCardModel(
                    boardId = 2,
                    username = "Fast Campus",
                    images = listOf(),
                    text = "내용2"
                ),
                BoardCardModel(
                    boardId = 3,
                    username = "Hung Bennett",
                    images = listOf(),
                    text = "내용3"
                )
            ),
            onOptionClick = {},
            onReplyClick = {}
        )
    }
}
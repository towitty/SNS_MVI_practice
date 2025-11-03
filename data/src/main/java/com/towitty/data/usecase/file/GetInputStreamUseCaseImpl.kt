package com.towitty.data.usecase.file

import android.content.Context
import com.towitty.domain.usecase.file.GetInputStreamUseCase
import java.io.InputStream
import javax.inject.Inject
import androidx.core.net.toUri


class GetInputStreamUseCaseImpl @Inject constructor(
    private val context: Context
) : GetInputStreamUseCase {
    override fun invoke(contentUri: String): Result<InputStream> = kotlin.runCatching {
        val uri = contentUri.toUri()
        context.contentResolver.openInputStream(uri)
            ?: throw IllegalStateException("InputStream 읽기 실패")
    }
}
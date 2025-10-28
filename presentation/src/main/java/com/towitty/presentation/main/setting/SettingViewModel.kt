package com.towitty.presentation.main.setting

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import com.towitty.domain.model.User
import com.towitty.domain.usecase.login.ClearTokenUseCase
import com.towitty.domain.usecase.main.setting.GetMyUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val clearTokenUseCase: ClearTokenUseCase,
    private val getMyUserUseCase: GetMyUserUseCase
) : ViewModel(), ContainerHost<SettingState, SettingSideEffect> {

    override val container: Container<SettingState, SettingSideEffect> =
        container(
            initialState = SettingState(),
            buildSettings = {
                this.exceptionHandler = CoroutineExceptionHandler { _, throwable ->
                    intent { postSideEffect(SettingSideEffect.Toast(throwable.message.orEmpty())) }
                }
            }
        )

    init {
        load()
    }

    private fun load() = intent {
        val user: User = getMyUserUseCase().getOrThrow()
        reduce {
            state.copy(
                profileImageUrl = user.profileImageUrl,
                username = user.username
            )
        }
    }

    fun onLogoutClick() = intent {
        clearTokenUseCase().getOrThrow()
        postSideEffect(SettingSideEffect.NavigateToLoginActivity)
    }

}

@Immutable
data class SettingState(
    val profileImageUrl: String? = null,
    val username: String = "",
)

sealed interface SettingSideEffect {

    class Toast(val message: String) : SettingSideEffect

    object NavigateToLoginActivity : SettingSideEffect
}
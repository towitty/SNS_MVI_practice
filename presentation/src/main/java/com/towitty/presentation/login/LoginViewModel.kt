package com.towitty.presentation.login

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.towitty.domain.usecase.login.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel(), ContainerHost<LoginState, LoginSideEffect> {

    override val container: Container<LoginState, LoginSideEffect> =
        container(
            initialState = LoginState(),
            buildSettings = {
                this.exceptionHandler = CoroutineExceptionHandler { _, throwable ->
                    intent {
                        postSideEffect(
                            LoginSideEffect.Toast(throwable.message.orEmpty())
                        )
                    }
                }
            }
        )

    fun onIdChange(id: String) = intent {
        reduce { state.copy(id = id) }
    }

    fun onPasswordChange(password: String) = intent {
        reduce { state.copy(password = password) }
    }

    fun onLoginClick() = intent {
        val id = state.id
        val password = state.password
        val token = loginUseCase(id, password)
        postSideEffect(LoginSideEffect.Toast("$token"))

    }
}

@Immutable
data class LoginState(
    val id: String = "",
    val password: String = ""
)

sealed interface LoginSideEffect {
    class Toast(val message: String) : LoginSideEffect
}
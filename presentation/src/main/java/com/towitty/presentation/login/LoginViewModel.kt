package com.towitty.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.towitty.domain.usecase.login.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    fun onLoginClick() {
        val id = ""
        val password = ""
        viewModelScope.launch {
            loginUseCase(id, password)
        }
    }
}
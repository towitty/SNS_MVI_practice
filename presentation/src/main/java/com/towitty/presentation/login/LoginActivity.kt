package com.towitty.presentation.login

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.towitty.presentation.theme.SNSTheme

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SNSTheme {
                LoginNavHost()
            }
        }
    }
}
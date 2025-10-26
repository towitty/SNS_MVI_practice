package com.towitty.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.dataStore by preferencesDataStore(name = "user_datastore")

class UserDataStore @Inject constructor(
    private val context: Context
) {

    companion object {
        private val KEY_TOKEN = stringPreferencesKey("token")
    }

    suspend fun getToken(): String? {
        return context.dataStore.data.map { it[KEY_TOKEN] }.firstOrNull()
    }

    suspend fun setToken(token: String) {
        context.dataStore.edit { pref ->
            pref[KEY_TOKEN] = token
        }
    }

    suspend fun clearToken() {
        context.dataStore.edit { it.clear() }
    }
}
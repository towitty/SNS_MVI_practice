package com.towitty.data.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.towitty.data.retrofit.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

val SNS_HOST = "http://localhost:8080"

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    fun provideOkhttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .build()
    }

    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        val converterFactory = Json {
            ignoreUnknownKeys = true
        }.asConverterFactory("application/json; charset=UTF8".toMediaType())

        return Retrofit.Builder()
            .baseUrl(SNS_HOST)
            .addConverterFactory(converterFactory)
            .client(client)
            .build()
    }

    @Provides
    fun provideUserService(retrofit: Retrofit): UserService {
        return retrofit.create(UserService::class.java)
    }
}
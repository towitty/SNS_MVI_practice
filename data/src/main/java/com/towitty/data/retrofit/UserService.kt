package com.towitty.data.retrofit

import com.towitty.data.model.CommonResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserService {

    @POST("users/login")
    @Headers("Content:Type-application/json; charset=UTF8")
    suspend fun login(
        @Body requestBody: RequestBody
    ): CommonResponse<String>

    @POST("users/sign-up")
    @Headers("Content:Type-application/json; charset=UTF8")
    suspend fun signUp(
        @Body requestBody: RequestBody
    ): CommonResponse<Long>
}
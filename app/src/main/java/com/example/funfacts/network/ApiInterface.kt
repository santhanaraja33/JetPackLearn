package com.example.funfacts.network

import com.example.funfacts.model.UserResponse
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface ApiInterface {
    @GET("todos")
    suspend fun getUserData():List<UserResponse>
}
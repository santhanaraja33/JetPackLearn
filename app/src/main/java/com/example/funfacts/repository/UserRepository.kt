package com.example.funfacts.repository

import com.example.funfacts.model.UserResponse
import com.example.funfacts.network.ApiInterface
import com.example.funfacts.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class UserRepository @Inject constructor(
    private val apiService: ApiInterface

) {
    suspend fun getUserResponse(): Resource<List<UserResponse>> {
        val response = try {
            apiService.getUserData()
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred : ${e.localizedMessage}")
        }

        return Resource.Success(response)
    }
}
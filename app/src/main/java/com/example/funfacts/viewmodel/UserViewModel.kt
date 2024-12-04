package com.example.funfacts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.funfacts.model.UserResponse
import com.example.funfacts.repository.UserRepository
import com.example.funfacts.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _userData = MutableLiveData<List<UserResponse>>(emptyList())
    val getUserData: LiveData<List<UserResponse>> = _userData

    val isLoading = MutableLiveData(false)

    suspend fun getUserData(): Resource<List<UserResponse>> {
        isLoading.value = true
        val result = repository.getUserResponse() // Assuming an API call or DB fetch
        if (result is Resource.Success) {
            _userData.postValue(result.data ?: emptyList())
        }
        isLoading.value = false
        return result
    }
}

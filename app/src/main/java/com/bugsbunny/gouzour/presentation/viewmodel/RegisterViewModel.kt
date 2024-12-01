package com.bugsbunny.gouzour.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bugsbunny.gouzour.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _signUpState = MutableStateFlow<SignUpState>(SignUpState.Idle)
    val registerStateFlow = _signUpState.asStateFlow()

    fun register(
        email: String,
        password: String,
        onSignUpSuccess: (id: String) -> Unit,
    ) {
        viewModelScope.launch {
            _signUpState.value = SignUpState.Loading
            try {
//                val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
//                _signUpState.value = SignUpState.Success(result.user)
//                onSignUpSuccess(result.user?.uid.toString())
            } catch (e: Exception) {
                _signUpState.value = SignUpState.Error(e.message ?: "Error creating account")
            }
        }
    }
}

sealed class SignUpState {
    object Idle : SignUpState()
    object Loading : SignUpState()
    data class Success(val user: Any?) : SignUpState()
    data class Error(val message: String) : SignUpState()
}
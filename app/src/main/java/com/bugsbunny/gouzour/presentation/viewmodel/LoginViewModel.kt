package com.bugsbunny.gouzour.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bugsbunny.gouzour.model.ProductDetailsDto
import com.bugsbunny.gouzour.repository.Repository
import com.bugsbunny.gouzour.util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginStateFlow = _loginState.asStateFlow()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginState.value = LoginState.Loading
            try {
//                val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
                // مستخدم عادي
//                _loginState.value = LoginState.UserSuccess(result.user)
            } catch (e: Exception) {
                _loginState.value = LoginState.Error(e.message ?: "Error logging in")
            }
        }
    }
}
sealed class LoginState {
    data object Idle : LoginState()
    data object Loading : LoginState()
    data class UserSuccess(val user: Any?) : LoginState()
    data class Error(val message: String) : LoginState()
}

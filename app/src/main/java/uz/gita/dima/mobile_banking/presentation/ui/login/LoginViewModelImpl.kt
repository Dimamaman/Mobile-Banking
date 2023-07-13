package uz.gita.dima.mobile_banking.presentation.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.gita.dima.mobile_banking.domain.usecase.AuthUseCase
import uz.gita.dima.mobile_banking.utils.getMessage
import uz.gita.dima.mobile_banking.utils.hasConnection
import javax.inject.Inject

@HiltViewModel
class LoginViewModelImpl @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val direction: LoginScreenDirection
) : LoginViewModel, ViewModel() {

    override val loadingSharedFlow = MutableSharedFlow<Boolean>()

    override val messageSharedFlow = MutableSharedFlow<String>()

    override val errorSharedFlow = MutableSharedFlow<String>()


    override fun login(phone: String, password: String) {
        viewModelScope.launch {
            if (hasConnection()) {
                loadingSharedFlow.emit(true)
                authUseCase.login(phone, password).collectLatest { result ->
                    loadingSharedFlow.emit(false)
                    result.onSuccess {
                        authUseCase.setToken(it.token)
                        direction.navigateToVerify()
                    }.onMessage {
                        messageSharedFlow.emit(it)
                    }.onError {
                        errorSharedFlow.emit(it.getMessage())
                    }
                }
            } else {
                messageSharedFlow.emit("No internet connection")
            }
        }
    }

    override fun navigateToRegister() {
        viewModelScope.launch {
            direction.navigateToRegister()
        }
    }

    override fun forgetPassword() {
        viewModelScope.launch {

        }
    }
}
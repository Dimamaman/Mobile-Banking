package uz.gita.dima.mobile_banking.presentation.ui.verify.login

import kotlinx.coroutines.flow.StateFlow
import uz.gita.dima.mobile_banking.presentation.ui.BaseViewModel

interface LoginVerifyViewModel : BaseViewModel {

    val startTimer: StateFlow<Boolean>

    fun navigateToPin()

    fun verifyCode(code: String)

    fun resendCode()

}
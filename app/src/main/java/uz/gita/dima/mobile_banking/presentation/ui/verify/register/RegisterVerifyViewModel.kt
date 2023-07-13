package uz.gita.dima.mobile_banking.presentation.ui.verify.register

import kotlinx.coroutines.flow.StateFlow
import uz.gita.dima.mobile_banking.presentation.ui.BaseViewModel

interface RegisterVerifyViewModel : BaseViewModel {

    val startTimer: StateFlow<Boolean>

    fun verifyCode(code:String)

    fun resendCode()

}
package uz.gita.dima.mobile_banking.presentation.ui.transfer.verify

import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import uz.gita.dima.mobile_banking.presentation.ui.BaseViewModel

interface TransferVerifyViewModel : BaseViewModel {

    val backSharedFlow:SharedFlow<Unit>

    val startTimer: StateFlow<Boolean>

    val tokenFlow:SharedFlow<String>

    fun verify(token:String,code:String)

    fun resendCode()

    fun navigateToMain()

}
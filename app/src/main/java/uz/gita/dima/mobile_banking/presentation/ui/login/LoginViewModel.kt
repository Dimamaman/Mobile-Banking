package uz.gita.dima.mobile_banking.presentation.ui.login

import uz.gita.dima.mobile_banking.presentation.ui.BaseViewModel

interface LoginViewModel : BaseViewModel {

    fun login(phone: String, password: String)

    fun navigateToRegister()

    fun forgetPassword()
}
package uz.gita.dima.mobile_banking.presentation.ui.login

interface LoginScreenDirection {

    suspend fun navigateToRegister()

    suspend fun navigateToVerify()

}
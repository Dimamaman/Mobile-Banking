package uz.gita.dima.mobile_banking.presentation.ui.login

import uz.gita.dima.mobile_banking.navigation.Navigator
import javax.inject.Inject

class LoginScreenDirectionImpl @Inject constructor(
    private val navigator: Navigator
) : LoginScreenDirection {
    override suspend fun navigateToRegister() {
        navigator.navigateTo(LoginScreenDirections.actionLoginScreenToRegisterScreen())
    }

    override suspend fun navigateToVerify() {
        navigator.navigateTo(LoginScreenDirections.actionLoginScreenToLoginVerifyScreen())
    }
}
package uz.gita.dima.mobile_banking.presentation.ui.register

import uz.gita.dima.mobile_banking.navigation.Navigator
import javax.inject.Inject

class RegisterScreenDirectionImpl @Inject constructor(
    private val navigator: Navigator
) : RegisterScreenDirection {
    override suspend fun navigateToLogin() {
//        navigator.navigateTo(RegisterScreenDirections.actionRegisterScreenToLoginScreen())
    }

    override suspend fun navigateToVerify() {
//        navigator.navigateTo(RegisterScreenDirections.actionRegisterScreenToRegisterVerifyScreen())
    }
}
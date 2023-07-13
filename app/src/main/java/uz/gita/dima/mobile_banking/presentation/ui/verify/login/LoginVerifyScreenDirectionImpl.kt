package uz.gita.dima.mobile_banking.presentation.ui.verify.login

import uz.gita.dima.mobile_banking.navigation.Navigator
import javax.inject.Inject

class LoginVerifyScreenDirectionImpl @Inject constructor(
    private val navigator: Navigator
) : LoginVerifyScreenDirection {
    override suspend fun navigateToPin() {
//        navigator.navigateTo(LoginVerifyScreenDirections.actionLoginVerifyScreenToPinScreen())
    }
}
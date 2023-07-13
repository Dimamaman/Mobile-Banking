package uz.gita.dima.mobile_banking.presentation.ui.verify.register

import uz.gita.dima.mobile_banking.navigation.Navigator
import javax.inject.Inject

class RegisterVerifyScreenDirectionImpl @Inject constructor(
    private val navigator: Navigator
) : RegisterVerifyScreenDirection {
    override suspend fun navigateToPin() {
//        navigator.navigateTo(RegisterVerifyScreenDirections.actionRegisterVerifyScreenToPinScreen())
    }
}
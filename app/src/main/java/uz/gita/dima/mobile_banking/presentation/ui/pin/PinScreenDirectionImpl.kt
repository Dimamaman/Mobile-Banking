package uz.gita.dima.mobile_banking.presentation.ui.pin

import uz.gita.dima.mobile_banking.navigation.Navigator
import javax.inject.Inject

class PinScreenDirectionImpl @Inject constructor(
    private val navigator: Navigator
) : PinScreenDirection {
    override suspend fun navigateToHome() {
//        navigator.navigateTo(PinScreenDirections.actionPinScreenToHomeScreen())
    }
}
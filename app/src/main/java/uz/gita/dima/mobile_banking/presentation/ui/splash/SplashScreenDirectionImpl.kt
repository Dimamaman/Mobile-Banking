package uz.gita.dima.mobile_banking.presentation.ui.splash


import javax.inject.Inject
import uz.gita.dima.mobile_banking.navigation.Navigator

class SplashScreenDirectionImpl @Inject constructor(
    private val navigator: Navigator
) : SplashScreenDirection {
    override suspend fun navigateToPassword() {
        navigator.navigateTo(SplashScreenDirections.actionSplashScreenToPinScreen())
    }

    override suspend fun navigateToLogin() {
        navigator.navigateTo(SplashScreenDirections.actionSplashScreenToLoginScreen())
    }
}
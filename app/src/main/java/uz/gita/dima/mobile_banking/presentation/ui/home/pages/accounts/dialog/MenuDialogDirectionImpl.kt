package uz.gita.dima.mobile_banking.presentation.ui.home.pages.accounts.dialog

import uz.gita.dima.mobile_banking.navigation.Navigator
import javax.inject.Inject

class MenuDialogDirectionImpl @Inject constructor(
    private val navigator: Navigator
): MenuDialogDirection {
    override suspend fun navigateToExchange() {
//        navigator.navigateTo(HomeScreenDirections.actionHomeScreenToExchangeScreen())
    }

    override suspend fun navigateToHistory() {
//       navigator.navigateTo(HomeScreenDirections.actionHomeScreenToHistoryScreen())
    }

    override suspend fun navigateToCards() {

    }

    override suspend fun navigateToSavedPayments() {

    }
}
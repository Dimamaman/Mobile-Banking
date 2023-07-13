package uz.gita.dima.mobile_banking.presentation.ui.transfer.verify

import uz.gita.dima.mobile_banking.navigation.Navigator
import javax.inject.Inject

class TransferVerifyScreenDirectionImpl @Inject constructor(
    private val navigator: Navigator
) : TransferVerifyScreenDirection {
    override suspend fun navigateToMain() {
//        navigator.navigateTo(TransferVerifyScreenDirections.actionTransferVerifyScreenToHomeScreen())
    }
}
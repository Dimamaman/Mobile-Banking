package uz.gita.dima.mobile_banking.presentation.ui.home.pages.accounts.dialog

import kotlinx.coroutines.flow.SharedFlow
import uz.gita.dima.mobile_banking.presentation.ui.BaseViewModel
import uz.gita.dima.mobile_banking.utils.MoreMenu

interface MenuViewModel : BaseViewModel {

    val openQrScannerFlow: SharedFlow<Unit>

    fun navigateTo(moreMenu: MoreMenu)

}
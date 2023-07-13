package uz.gita.dima.mobile_banking.presentation.ui.home.pages.accounts.dialog

interface MenuDialogDirection {

    suspend fun navigateToExchange()

    suspend fun navigateToHistory()

    suspend fun navigateToCards()

    suspend fun navigateToSavedPayments()

}
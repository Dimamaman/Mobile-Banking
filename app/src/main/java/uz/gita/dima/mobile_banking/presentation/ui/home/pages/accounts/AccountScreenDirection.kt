package uz.gita.dima.mobile_banking.presentation.ui.home.pages.accounts

import uz.gita.dima.mobile_banking.data.remote.response.card.CardData
import uz.gita.dima.mobile_banking.data.remote.response.user.LastTransferData

interface AccountScreenDirection {

    suspend fun navigateToAddCard()

    suspend fun navigateToCardDetail(cardData: CardData)

    suspend fun navigateToNotification()

    suspend fun navigateToPayment()

    suspend fun navigateToSend()

    suspend fun navigateToTransferDetail(transferData: LastTransferData)

    suspend fun navigateToSearch()

}
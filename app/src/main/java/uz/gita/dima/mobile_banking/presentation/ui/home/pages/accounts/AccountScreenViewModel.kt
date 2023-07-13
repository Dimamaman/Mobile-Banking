package uz.gita.dima.mobile_banking.presentation.ui.home.pages.accounts

import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import uz.gita.dima.mobile_banking.data.remote.response.card.CardData
import uz.gita.dima.mobile_banking.data.remote.response.user.LastTransferData
import uz.gita.dima.mobile_banking.presentation.ui.BaseViewModel

interface AccountScreenViewModel : BaseViewModel {

    val cardsList: StateFlow<List<CardData>>

    val lastTransactions:StateFlow<List<LastTransferData>>

    val errorCardsMessage:SharedFlow<String>

    val openMoreDialog:SharedFlow<Unit>

    fun getCards()

    fun getLastTransfers()

    fun navigateToAddCard()

    fun navigateToPayment()

    fun navigateToSend()

    fun clickMore()

    fun navigateToNotification()

    fun searchLastTransfers()

    fun navigateToCardDetails(cardData: CardData)

    fun navigateToLastTransfersDetail(lastTransferData: LastTransferData)

}

package uz.gita.dima.mobile_banking.presentation.ui.transfer

import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import uz.gita.dima.mobile_banking.data.remote.response.card.CardData
import uz.gita.dima.mobile_banking.presentation.ui.BaseViewModel

interface TransferViewModel : BaseViewModel {

    val cardFlow: StateFlow<List<CardData>>

    val userFlow: SharedFlow<String>

    val openConfirmDialog: SharedFlow<Pair<CardData, String>>

    fun back()

    fun getCards()

    fun getUser(cardNumber: String)

    fun transferVerify(amount: Int, receiverPan: String, cardNumber: Int)

    fun navigateToVerify(
        cardData: CardData,
        receiverName: String,
        receiverPan: String,
        amount: Int,
        token: String
    )

}
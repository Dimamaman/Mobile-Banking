package uz.gita.dima.mobile_banking.presentation.ui.transfer

import uz.gita.dima.mobile_banking.data.remote.response.card.CardData

interface TransferScreenDirection {

    suspend fun navigateToVerify(
        cardData: CardData,
        receiverName: String,
        receiverPan: String,
        amount: Int,
        token: String
    )

}
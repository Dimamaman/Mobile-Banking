package uz.gita.dima.mobile_banking.presentation.ui.transfer

import uz.gita.dima.mobile_banking.data.remote.response.card.CardData
import uz.gita.dima.mobile_banking.navigation.Navigator
import javax.inject.Inject

class TransferScreenDirectionImp @Inject constructor(
    private val navigator: Navigator
) : TransferScreenDirection {
    override suspend fun navigateToVerify(
        cardData: CardData,
        receiverName: String,
        receiverPan: String,
        amount: Int,
        token: String
    ) {

//        navigator.navigateTo(
//            TransferScreenDirections.actionTransferScreenToTransferVerifyScreen(
//                cardData = cardData,
//                recipientName = receiverName,
//                recipientPan = receiverPan,
//                amount = amount,
//                token = token
//            )
//        )
    }
}
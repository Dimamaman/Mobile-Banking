package uz.gita.dima.mobile_banking.presentation.ui.card.detail

import androidx.paging.PagingData
import kotlinx.coroutines.flow.StateFlow
import uz.gita.dima.mobile_banking.data.remote.response.card.CardData
import uz.gita.dima.mobile_banking.data.remote.response.transfer.TransferData
import uz.gita.dima.mobile_banking.presentation.ui.BaseViewModel

interface CardDetailViewModel : BaseViewModel {

    val transfersByCard: StateFlow<PagingData<TransferData>>

    fun getTransfersByCard(cardData: CardData)


}
package uz.gita.dima.mobile_banking.presentation.ui.history

import androidx.paging.PagingData
import kotlinx.coroutines.flow.SharedFlow
import uz.gita.dima.mobile_banking.data.remote.response.transfer.TransferData
import uz.gita.dima.mobile_banking.presentation.ui.BaseViewModel

interface HistoryViewModel : BaseViewModel {

    val transferHistoryFlow: SharedFlow<PagingData<TransferData>>

    fun getTransfers()

}
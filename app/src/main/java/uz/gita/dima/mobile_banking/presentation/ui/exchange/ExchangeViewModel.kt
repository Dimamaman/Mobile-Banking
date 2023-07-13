package uz.gita.dima.mobile_banking.presentation.ui.exchange

import kotlinx.coroutines.flow.StateFlow
import uz.gita.dima.mobile_banking.data.remote.response.exchange.ExchangeData
import uz.gita.dima.mobile_banking.presentation.ui.BaseViewModel

interface ExchangeViewModel : BaseViewModel {

    val allExchanges:StateFlow<List<ExchangeData>>

    fun getAllExchanges()
}
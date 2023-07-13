package uz.gita.dima.mobile_banking.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.dima.mobile_banking.data.remote.response.exchange.ExchangeData
import uz.gita.dima.mobile_banking.utils.ResultData

interface GetAllExchanges {
    fun invoke():Flow<ResultData<List<ExchangeData>>>
}
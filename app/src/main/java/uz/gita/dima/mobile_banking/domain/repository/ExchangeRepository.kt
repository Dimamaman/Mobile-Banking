package uz.gita.dima.mobile_banking.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.dima.mobile_banking.data.remote.response.exchange.ExchangeData
import uz.gita.dima.mobile_banking.utils.ResultData

interface ExchangeRepository {
    fun getAllExchanges(): Flow<ResultData<List<ExchangeData>>>
}
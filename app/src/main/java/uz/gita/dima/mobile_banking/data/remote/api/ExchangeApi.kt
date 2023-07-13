package uz.gita.dima.mobile_banking.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import uz.gita.dima.mobile_banking.data.remote.response.exchange.ExchangeData

interface ExchangeApi {

    @GET("/uzc/arkhiv-kursov-valyut/json/")
    suspend fun getAllCurrency(): Response<List<ExchangeData>>

}
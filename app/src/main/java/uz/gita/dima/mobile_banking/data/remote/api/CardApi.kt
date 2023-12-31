package uz.gita.dima.mobile_banking.data.remote.api

import retrofit2.Response
import retrofit2.http.*
import uz.gita.dima.mobile_banking.data.remote.request.card.CardDto
import uz.gita.dima.mobile_banking.data.remote.request.card.UpdateCardDto
import uz.gita.dima.mobile_banking.data.remote.response.card.CardData
import uz.gita.dima.mobile_banking.data.remote.response.user.MessageData

interface CardApi {

    @GET("card")
    suspend fun getAllCards(): Response<List<CardData>>

    @POST("card")
    suspend fun addCard(@Body cardDto: CardDto): Response<MessageData>

    @PUT("card")
    suspend fun updateCard(@Body updateCardDto: UpdateCardDto): Response<MessageData>

    @DELETE("card/{id}")
    suspend fun deleteCard(@Path("id") cardId: Int)

}
package uz.gita.dima.mobile_banking.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.dima.mobile_banking.data.remote.request.card.CardDto
import uz.gita.dima.mobile_banking.data.remote.request.card.UpdateCardDto
import uz.gita.dima.mobile_banking.data.remote.response.card.CardData
import uz.gita.dima.mobile_banking.data.remote.response.user.MessageData
import uz.gita.dima.mobile_banking.utils.ResultData

interface CardRepository {

    fun getAllCards(): Flow<ResultData<List<CardData>>>

    fun addCard(cardDto: CardDto): Flow<ResultData<MessageData>>

    fun updateCard(updateCardDto: UpdateCardDto): Flow<ResultData<MessageData>>

    suspend fun deleteCard(cardId: Int)

}
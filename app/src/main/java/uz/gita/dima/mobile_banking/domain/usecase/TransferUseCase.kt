package uz.gita.dima.mobile_banking.domain.usecase

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import uz.gita.dima.mobile_banking.data.remote.request.transfer.*
import uz.gita.dima.mobile_banking.data.remote.response.auth.TokenData
import uz.gita.dima.mobile_banking.data.remote.response.card.CardData
import uz.gita.dima.mobile_banking.data.remote.response.transfer.PanData
import uz.gita.dima.mobile_banking.data.remote.response.transfer.TransferData
import uz.gita.dima.mobile_banking.data.remote.response.transfer.TransferFreeData
import uz.gita.dima.mobile_banking.data.remote.response.user.MessageData
import uz.gita.dima.mobile_banking.utils.ResultData

interface TransferUseCase {
    fun addPan(panDto: PanDto): Flow<ResultData<PanData>>

    fun getCardOwnerByPan(panDto: PanDto): Flow<ResultData<PanData>>

    fun addFreeTransfer(transferFreeDto: TransferFreeDto): Flow<ResultData<TransferFreeData>>

    fun addTransfer(transferDto: TransferDto): Flow<ResultData<TokenData>>

    fun transferVerify(transferVerifyDto: TransferVerifyDto): Flow<ResultData<MessageData>>

    fun getTransfers(
        size: Int,
        currentPage: Int
    ): Flow<PagingData<TransferData>>

    fun resendTransfer(tokenDto: TokenDto): Flow<ResultData<TokenData>>

    fun getTransfersByCard(cardData: CardData):Flow<PagingData<TransferData>>
}
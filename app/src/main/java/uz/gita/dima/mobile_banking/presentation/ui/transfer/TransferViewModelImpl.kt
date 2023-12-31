package uz.gita.dima.mobile_banking.presentation.ui.transfer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.gita.dima.mobile_banking.data.remote.request.transfer.PanDto
import uz.gita.dima.mobile_banking.data.remote.request.transfer.TransferDto
import uz.gita.dima.mobile_banking.data.remote.response.card.CardData
import uz.gita.dima.mobile_banking.domain.usecase.CardUseCase
import uz.gita.dima.mobile_banking.domain.usecase.TransferUseCase
import uz.gita.dima.mobile_banking.utils.getMessage
import uz.gita.dima.mobile_banking.utils.hasConnection
import javax.inject.Inject

@HiltViewModel
class TransferViewModelImpl @Inject constructor(
    private val transferUseCase: TransferUseCase,
    private val cardUseCase: CardUseCase,
    private val direction: TransferScreenDirection
) : TransferViewModel, ViewModel() {
    override val loadingSharedFlow = MutableSharedFlow<Boolean>()

    override val messageSharedFlow = MutableSharedFlow<String>()

    override val errorSharedFlow = MutableSharedFlow<String>()

    override val cardFlow = MutableStateFlow<List<CardData>>(emptyList())

    override val userFlow = MutableSharedFlow<String>()

    override val openConfirmDialog = MutableSharedFlow<Pair<CardData, String>>()

    override fun back() {
        viewModelScope.launch {
            direction.back()
        }
    }

    private var cardsList: List<CardData> = emptyList()

    override fun getCards() {
        viewModelScope.launch {
            if (hasConnection()) {
                loadingSharedFlow.emit(true)
                cardUseCase.getAllCards().collectLatest { result ->
                    loadingSharedFlow.emit(false)
                    result.onSuccess {
                        cardsList = it
                        cardFlow.emit(it)
                    }.onError {
                        errorSharedFlow.emit(it.getMessage())
                    }.onMessage {
                        messageSharedFlow.emit(it)
                    }
                }
            } else {
                messageSharedFlow.emit("No internet connection")
            }
        }
    }

    override fun getUser(cardNumber: String) {
        viewModelScope.launch {
            if (hasConnection()) {
                transferUseCase.getCardOwnerByPan(PanDto(cardNumber)).collectLatest { result ->
                    result.onSuccess {
                        userFlow.emit(it.pan)
                    }.onError {
                        errorSharedFlow.emit(it.getMessage())
                    }.onMessage {
                        userFlow.emit(it)
                    }
                }
            } else {
                messageSharedFlow.emit("No internet connection")
            }
        }
    }

    override fun transferVerify(amount: Int, receiverPan: String, cardNumber: Int) {
        viewModelScope.launch {
            if (hasConnection()) {
                loadingSharedFlow.emit(true)
                transferUseCase.addTransfer(
                    TransferDto(
                        type = "third-card",
                        senderId = cardsList[cardNumber].id.toString(),
                        receiverPan = receiverPan,
                        amount = amount
                    )
                ).collectLatest { result ->
                    loadingSharedFlow.emit(false)
                    result.onSuccess {
                        openConfirmDialog.emit(Pair(cardsList[cardNumber], it.token))
                    }.onMessage {
                        messageSharedFlow.emit(it)
                    }.onError {
                        errorSharedFlow.emit(it.getMessage())
                    }
                }
            } else {
                messageSharedFlow.emit("No internet connection")
            }
        }
    }

    override fun navigateToVerify(
        cardData: CardData,
        receiverName: String,
        receiverPan: String,
        amount: Int,
        token: String
    ) {
        viewModelScope.launch {
            direction.navigateToVerify(cardData, receiverName, receiverPan, amount, token)
        }
    }
}
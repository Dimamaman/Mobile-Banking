package uz.gita.dima.mobile_banking.presentation.ui.card.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.gita.dima.mobile_banking.data.remote.response.card.CardData
import uz.gita.dima.mobile_banking.data.remote.response.transfer.TransferData
import uz.gita.dima.mobile_banking.domain.usecase.TransferUseCase
import uz.gita.dima.mobile_banking.utils.hasConnection
import javax.inject.Inject

@HiltViewModel
class CardDetailViewModelImpl @Inject constructor(
    private val transferUseCase: TransferUseCase
) : CardDetailViewModel,ViewModel() {
    override val loadingSharedFlow = MutableSharedFlow<Boolean>()

    override val messageSharedFlow = MutableSharedFlow<String>()

    override val errorSharedFlow = MutableSharedFlow<String>()

    override val transfersByCard = MutableStateFlow<PagingData<TransferData>>(PagingData.empty())

    override fun getTransfersByCard(cardData: CardData) {
        viewModelScope.launch {
            loadingSharedFlow.emit(true)
            if (hasConnection()){
                transferUseCase.getTransfersByCard(cardData).collectLatest {
                    loadingSharedFlow.emit(false)
                    transfersByCard.emit(it)
                }
            }else{
                messageSharedFlow.emit("No internet connection")
                loadingSharedFlow.emit(false)
            }
        }
    }
}
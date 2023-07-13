package uz.gita.dima.mobile_banking.presentation.ui.card.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.gita.dima.mobile_banking.data.remote.request.card.CardDto
import uz.gita.dima.mobile_banking.domain.usecase.CardUseCase
import uz.gita.dima.mobile_banking.utils.getMessage
import javax.inject.Inject

@HiltViewModel
class AddCardViewModelImpl @Inject constructor(
    private val cardUseCase: CardUseCase
) : AddCardViewModel, ViewModel() {
    override val loadingSharedFlow = MutableSharedFlow<Boolean>()

    override val messageSharedFlow = MutableSharedFlow<String>()

    override val errorSharedFlow = MutableSharedFlow<String>()

    override val backSharedFlow = MutableSharedFlow<String>()


    override fun addCard(
        cardName: String,
        cardNumber: String,
        expiredMonth: String,
        expiredYear: String
    ) {
        viewModelScope.launch {
            loadingSharedFlow.emit(true)
            cardUseCase.addCard(
                CardDto(
                    pan = cardNumber,
                    expiredMonth = expiredMonth,
                    expiredYear = expiredYear,
                    name = cardName
                )
            ).collectLatest { result ->
                loadingSharedFlow.emit(false)
                result.onSuccess {
                    backSharedFlow.emit(it.message)
                }.onMessage {
                    messageSharedFlow.emit(it)
                }.onError {
                    errorSharedFlow.emit(it.getMessage())
                }
            }
        }
    }
}
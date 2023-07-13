package uz.gita.dima.mobile_banking.presentation.ui.card.add

import kotlinx.coroutines.flow.SharedFlow
import uz.gita.dima.mobile_banking.presentation.ui.BaseViewModel

interface AddCardViewModel : BaseViewModel {

    val backSharedFlow:SharedFlow<String>

    fun addCard(cardName: String, cardNumber: String, expiredMonth: String, expiredYear: String)

}
package uz.gita.dima.mobile_banking.presentation.ui.payment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import uz.gita.dima.mobile_banking.domain.models.enums.PaymentDirection
import uz.gita.dima.mobile_banking.domain.models.enums.PaymentType
import javax.inject.Inject

class PaymentViewModelImpl @Inject constructor() : PaymentViewModel, ViewModel() {

    override val paymentTypeFlow = MutableStateFlow(PaymentDirection.LINEAR)

    override fun navigateToSearchPayment() {

    }

    override fun changePaymentType(paymentDirection: PaymentDirection) {
        viewModelScope.launch {
            paymentTypeFlow.emit(paymentDirection)
        }
    }

    override fun navigateToPaymentDetail(paymentType: PaymentType) {

    }
}
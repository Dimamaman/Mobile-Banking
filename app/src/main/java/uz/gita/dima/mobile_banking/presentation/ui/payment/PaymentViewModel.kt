package uz.gita.dima.mobile_banking.presentation.ui.payment

import kotlinx.coroutines.flow.StateFlow
import uz.gita.dima.mobile_banking.domain.models.enums.PaymentDirection
import uz.gita.dima.mobile_banking.domain.models.enums.PaymentType

interface PaymentViewModel {

    val paymentTypeFlow: StateFlow<PaymentDirection>

    fun navigateToSearchPayment()

    fun changePaymentType(paymentDirection: PaymentDirection)

    fun navigateToPaymentDetail(paymentType: PaymentType)

}
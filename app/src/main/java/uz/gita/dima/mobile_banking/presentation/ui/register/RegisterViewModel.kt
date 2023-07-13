package uz.gita.dima.mobile_banking.presentation.ui.register

import uz.gita.dima.mobile_banking.presentation.ui.BaseViewModel

interface RegisterViewModel : BaseViewModel {

    fun register(
        phone: String,
        password: String,
        firstName: String,
        lastName: String,
        bornDate: Long,
        gender: Int
    )

    fun navigateToSignIn()

}
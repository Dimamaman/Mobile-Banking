package uz.gita.dima.mobile_banking.presentation.ui.pin

import kotlinx.coroutines.flow.SharedFlow

interface PinViewModel {

    val isFirstSharedFlow: SharedFlow<Boolean>

    val errorSharedFlow:SharedFlow<String>

    val backSharedFlow:SharedFlow<Boolean>

    fun navigateToMain(password: String)

    fun savePassword(password: String)

    fun getIsFirst()

    fun check(password: String)

}
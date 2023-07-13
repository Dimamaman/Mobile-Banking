package uz.gita.dima.mobile_banking.presentation.ui

import kotlinx.coroutines.flow.SharedFlow

interface BaseViewModel {

    val loadingSharedFlow: SharedFlow<Boolean>

    val messageSharedFlow: SharedFlow<String>

    val errorSharedFlow: SharedFlow<String>

}
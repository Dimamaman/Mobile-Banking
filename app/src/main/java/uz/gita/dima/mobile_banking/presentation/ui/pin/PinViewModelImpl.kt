package uz.gita.dima.mobile_banking.presentation.ui.pin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import uz.gita.dima.mobile_banking.MainActivity
import uz.gita.dima.mobile_banking.domain.usecase.AuthUseCase
import uz.gita.dima.mobile_banking.domain.usecase.UserUseCase
import javax.inject.Inject

@HiltViewModel
class PinViewModelImpl @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val direction: PinScreenDirection,
    private val useCase: UserUseCase
) : PinViewModel, ViewModel() {

    override val isFirstSharedFlow = MutableSharedFlow<Boolean>()

    override val errorSharedFlow = MutableSharedFlow<String>()

    override val backSharedFlow = MutableSharedFlow<Boolean>()


    override fun navigateToMain(password: String) {
        viewModelScope.launch {
            useCase.setPassword(password)
            direction.navigateToHome()
        }
    }

    override fun savePassword(password: String) {
        viewModelScope.launch {
            useCase.setPassword(password)
            direction.navigateToHome()
        }
    }

    override fun getIsFirst() {
        viewModelScope.launch {
            isFirstSharedFlow.emit(useCase.getPassword().isEmpty())
        }
    }

    override fun check(password: String) {
        viewModelScope.launch {
            if (useCase.getPassword() == password) {
                if (MainActivity.isFirstApp)
                    direction.navigateToHome()
                else{
                    backSharedFlow.emit(true)
                }
            } else {
                errorSharedFlow.emit("Incorrect password")
            }
        }
    }
}
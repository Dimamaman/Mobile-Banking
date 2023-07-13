package uz.gita.dima.mobile_banking.presentation.ui.splash

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.dima.mobile_banking.domain.usecase.StartScreenUseCase
import javax.inject.Inject

@HiltViewModel
class SplashViewModelImpl @Inject constructor(
    private val useCase: StartScreenUseCase,
    private val directions: SplashScreenDirection
): SplashViewModel, ViewModel() {

    override fun navigate() {

    }
}
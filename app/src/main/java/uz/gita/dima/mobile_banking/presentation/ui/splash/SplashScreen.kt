package uz.gita.dima.mobile_banking.presentation.ui.splash

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.dima.mobile_banking.R

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreen: Fragment(R.layout.screen_splash) {
    private val viewModel: SplashViewModel by viewModels<SplashViewModelImpl>()


}
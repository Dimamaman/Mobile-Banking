package uz.gita.dima.mobile_banking.presentation.ui.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import uz.gita.dima.mobile_banking.R

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreen: Fragment(R.layout.screen_splash) {
    private val viewModel: SplashViewModel by viewModels<SplashViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lifecycleScope.launchWhenResumed {
            delay(1000)
            viewModel.navigate()
        }
    }
}
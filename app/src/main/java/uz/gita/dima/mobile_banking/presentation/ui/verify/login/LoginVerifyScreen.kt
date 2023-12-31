package uz.gita.dima.mobile_banking.presentation.ui.verify.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.fraggjkee.smsconfirmationview.SmsConfirmationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.ldralighieri.corbind.view.clicks
import uz.gita.dima.mobile_banking.R
import uz.gita.dima.mobile_banking.databinding.ScreenLoginVerifyBinding
import uz.gita.dima.mobile_banking.utils.getTimeFormat
import uz.gita.dima.mobile_banking.utils.include

@AndroidEntryPoint
class LoginVerifyScreen : Fragment(R.layout.screen_login_verify){
    private val viewBinding: ScreenLoginVerifyBinding by viewBinding()

    private val viewModel: LoginVerifyViewModel by viewModels<LoginVerifyViewModelImpl>()

    private var isCompletedSms: Boolean = false

    private var isFinishedTime: Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = viewBinding.include {

        smsChecker.onChangeListener = SmsConfirmationView.OnChangeListener { _, isComplete ->
            isCompletedSms = isComplete
            check()
        }
        tvTimeExpired.clicks().onEach {
            if (isFinishedTime) {
                isFinishedTime = false
                viewModel.resendCode()
                runTimer()
                check()
            }
        }.launchIn(lifecycleScope)


        viewModel.startTimer.onEach {
            runTimer()
        }.launchIn(viewLifecycleOwner.lifecycleScope)

        btnConfirmCode.clicks()
            .onEach {
                viewModel.verifyCode(smsChecker.enteredCode)
            }.launchIn(lifecycleScope)
    }

    private fun runTimer() = viewBinding.include {
        var time = 180
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            while (time > 0) {
                tvTimeExpired.text = time.getTimeFormat()
                delay(1000)
                time--
            }
            isFinishedTime = true
            check()
        }
    }

    private fun check() = viewBinding.include {
        btnConfirmCode.isEnabled = isCompletedSms && !isFinishedTime
    }
}
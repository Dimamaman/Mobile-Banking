package uz.gita.dima.mobile_banking.presentation.ui.pin

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.ldralighieri.corbind.view.clicks
import ru.ldralighieri.corbind.widget.textChanges
import uz.gita.dima.mobile_banking.R
import uz.gita.dima.mobile_banking.databinding.ScreenPinBinding
import uz.gita.dima.mobile_banking.utils.include
import uz.gita.dima.mobile_banking.utils.showErrorDialog
import uz.gita.dima.mobile_banking.utils.toast

@AndroidEntryPoint
class PinScreen : Fragment(R.layout.screen_pin){
    private val viewBinding: ScreenPinBinding by viewBinding()

    private val viewModel: PinViewModel by viewModels<PinViewModelImpl>()

    private var isCompleted: Boolean = false

    private var isFirst: Boolean = true

    private var oldPassword = ""

    private var counter = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = viewBinding.include {

        pinView.textChanges()
            .onEach {
                isCompleted = it.length == 4
                check()
            }.launchIn(viewLifecycleOwner.lifecycleScope)

        initView()

        viewModel.backSharedFlow.onEach {
            findNavController().navigateUp()
        }.launchIn(lifecycleScope)

        viewModel.isFirstSharedFlow.onEach {
            isFirst = it
        }.launchIn(lifecycleScope)

        viewModel.errorSharedFlow.onEach {
            showErrorDialog(it)
        }.launchIn(lifecycleScope)

        viewModel.getIsFirst()

        imageDelete.clicks()
            .onEach {
                var text = pinView.text.toString()
                if (text.isNotEmpty()) {
                    text = text.substring(0, text.lastIndex)
                    pinView.setText(text)
                }
            }.launchIn(lifecycleScope)


    }

    private fun check() = viewBinding.include {
        if (isCompleted) {
            if (counter == 0) {
                oldPassword = pinView.text.toString()
                if (isFirst) {
                    counter++
                    pinView.setText("")
                    tvInputPinCode.text = resources.getString(R.string.confirm_new_password)
                } else {
                    viewModel.check(oldPassword)
                }
            } else {
                val password: String = pinView.text.toString()
                if (password == oldPassword) {
                    viewModel.savePassword(password)
                } else {
                    toast("Incorrect password!!!")
                }
            }
        }
    }

    private fun initView() = viewBinding.include {
        val container = llNumberContainer
        val size = container.childCount
        for (i in 0 until size) {
            val group: ViewGroup = container.getChildAt(i) as ViewGroup
            for (j in 0 until group.childCount) {
                val view = group.getChildAt(j)
                view.setOnClickListener {
                    if (view is Button) {
                        if (!isCompleted) {
                            pinView.append(view.text)
                        }
                    }
                }
            }
        }
    }

}
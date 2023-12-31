package uz.gita.dima.mobile_banking.presentation.ui.transfer

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.razir.progressbutton.hideProgress
import com.github.razir.progressbutton.showProgress
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.ldralighieri.corbind.view.clicks
import ru.ldralighieri.corbind.widget.textChanges
import uz.gita.dima.mobile_banking.R
import uz.gita.dima.mobile_banking.databinding.ScreenTransferBinding
import uz.gita.dima.mobile_banking.presentation.ui.home.pages.accounts.adapter.CardAdapter
import uz.gita.dima.mobile_banking.utils.*

@AndroidEntryPoint
class TransferScreen : Fragment(R.layout.screen_transfer){
    private val viewBinding: ScreenTransferBinding by viewBinding()

    private val viewModel: TransferViewModel by viewModels<TransferViewModelImpl>()

    private var current = 0

    private var boolAmount: Boolean = false

    private var boolSendTo: Boolean = false

    private lateinit var cardAdapter: CardAdapter

    @OptIn(FlowPreview::class)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = viewBinding.include {

        viewModel.loadingSharedFlow.onEach {
            if (it) {
                btnTransfer.showProgress {
                    buttonTextRes = R.string.next
                }
            } else {
                btnTransfer.hideProgress()
            }
        }.launchIn(lifecycleScope)

        viewModel.messageSharedFlow.onEach {
            showMessageDialog(it)
        }.launchIn(lifecycleScope)

        viewModel.errorSharedFlow.onEach {
            showErrorDialog(it)
        }.launchIn(lifecycleScope)

        inputAmount.addTextChangedListener(MaskWatcherPayment(inputAmount))

        cardAdapter = CardAdapter()

        listCards.adapter = cardAdapter

        viewModel.cardFlow.onEach {
            cardAdapter.submitList(it)
        }.launchIn(viewLifecycleOwner.lifecycleScope)

        viewModel.userFlow.onEach {
            tvIdentifiedUser.text = it
        }.launchIn(lifecycleScope)

        inputAmount.textChanges().debounce(100L).onEach {
            boolAmount = it.length >= 4
            check()
        }.launchIn(viewLifecycleOwner.lifecycleScope)

        inputSendTo.textChanges().debounce(100L).onEach {
            boolSendTo = inputSendTo.rawText.length == 16
            if (boolSendTo) {
                viewModel.getUser(inputSendTo.rawText)
            }
            check()
        }.launchIn(lifecycleScope)

        viewModel.openConfirmDialog.onEach {
            viewModel.navigateToVerify(
                cardData = it.first,
                receiverName = tvIdentifiedUser.text.toString(),
                receiverPan = inputSendTo.rawText,
                amount = inputAmount.text.toString().getDigitOnly(),
                token = it.second
            )
        }.launchIn(lifecycleScope)

        btnTransfer.clicks()
            .onEach {
                val amount = inputAmount.text.toString().getDigitOnly()
                val card = inputSendTo.rawText.toString()
                viewModel.transferVerify(amount, card, current)
            }.launchIn(lifecycleScope)

        viewModel.getCards()

        viewBinding.imageBack.clicks()
            .onEach {
                viewModel.back()
            }.launchIn(lifecycleScope)

    }

    private fun check() = viewBinding.include {
        btnTransfer.isEnabled = boolSendTo && boolAmount
    }
}
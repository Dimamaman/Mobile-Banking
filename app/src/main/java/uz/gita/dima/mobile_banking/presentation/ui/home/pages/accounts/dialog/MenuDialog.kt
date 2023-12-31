package uz.gita.dima.mobile_banking.presentation.ui.home.pages.accounts.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.dima.mobile_banking.R
import uz.gita.dima.mobile_banking.databinding.DialogBottomMenuBinding
import uz.gita.dima.mobile_banking.presentation.ui.home.pages.accounts.adapter.MenuAdapter
import uz.gita.dima.mobile_banking.utils.Constants
import uz.gita.dima.mobile_banking.utils.include

@AndroidEntryPoint
class MenuDialog : BottomSheetDialogFragment(R.layout.dialog_bottom_menu) {

    private val viewBinding: DialogBottomMenuBinding by viewBinding()

    private val viewModel: MenuViewModel by viewModels<MenuViewModelImpl>()

    private val adapter: MenuAdapter by lazy(LazyThreadSafetyMode.NONE) {
        MenuAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = viewBinding.include {

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        listMenu.adapter = adapter

        viewModel.openQrScannerFlow.onEach {
            dismiss()
        }.launchIn(lifecycleScope)

        adapter.setItemClickListener {
            dismiss()
            viewModel.navigateTo(it.menu)
        }
        adapter.submitList(Constants.moreMenuList)
    }
}
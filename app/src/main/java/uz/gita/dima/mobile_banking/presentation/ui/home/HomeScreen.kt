package uz.gita.dima.mobile_banking.presentation.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.dima.mobile_banking.R
import uz.gita.dima.mobile_banking.databinding.ScreenHomeBinding
import uz.gita.dima.mobile_banking.utils.include

@AndroidEntryPoint
class HomeScreen : Fragment(R.layout.screen_home) {

    private val viewBinding: ScreenHomeBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = viewBinding.include {
        viewBinding.pagerHome.apply {
            isUserInputEnabled = false
            adapter = HomePagerAdapter(requireActivity())
        }

        bnvHome.setOnItemSelectedListener {
            val pos = when (it.itemId) {
                R.id.menu_account -> 0
                R.id.menu_statistics -> 1
                R.id.menu_chat -> 2
                else -> 3
            }
            pagerHome.setCurrentItem(pos, true)
            true
        }
    }
}
package uz.gita.dima.mobile_banking.presentation.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.gita.dima.mobile_banking.presentation.ui.home.pages.accounts.AccountsScreen
import uz.gita.dima.mobile_banking.presentation.ui.home.pages.chat.ChatScreen
import uz.gita.dima.mobile_banking.presentation.ui.home.pages.settings.SettingsScreen
import uz.gita.dima.mobile_banking.presentation.ui.home.pages.statistics.StatisticsScreen


class HomePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> AccountsScreen()
            1 -> StatisticsScreen()
            2 -> ChatScreen()
            else -> SettingsScreen()
        }
}
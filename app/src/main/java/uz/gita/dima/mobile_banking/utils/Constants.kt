package uz.gita.dima.mobile_banking.utils

import uz.gita.dima.mobile_banking.R

object Constants {
    val moreMenuList = listOf(
        MoreMenuData(R.drawable.ic_exchange, MoreMenu.EXCHANGE),
        MoreMenuData(R.drawable.ic_history, MoreMenu.HISTORY),
        MoreMenuData(R.drawable.ic_card, MoreMenu.CARDS),
        MoreMenuData(R.drawable.ic_scanner, MoreMenu.QR_PAYMENT),
        MoreMenuData(R.drawable.ic_favorite, MoreMenu.SAVED_PAYMENT),
    )
}

data class MoreMenuData(val imageId: Int, val menu: MoreMenu)

enum class MoreMenu(val menuName: String) {
    EXCHANGE("Exchange"),
    HISTORY("History"),
    CARDS("Cards"),
    QR_PAYMENT("Qr payments"),
    SAVED_PAYMENT("Saved Payments")
}
package uz.gita.dima.mobile_banking.data.local.models.card

data class CardEntity(
    val id: Int,
    val amount: Int,
    val expiredMonth: Int,
    val expiredYear: Int,
    val isVisible: Boolean,
    val name: String,
    val owner: String,
    val pan: String,
    val themeType: Int
)

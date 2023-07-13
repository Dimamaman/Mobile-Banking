package uz.gita.dima.mobile_banking.data.local.models.user

data class UserEntity(
    val phone: String,
    val firstName: String,
    val lastName: String,
    val bornDate: Long,
    val gender: Int
)

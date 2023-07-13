package uz.gita.dima.mobile_banking.data.local.models.user

data class ProfileEntity(
    val firstName: String,
    val genderType: Int = 0,
    val age: Int
)

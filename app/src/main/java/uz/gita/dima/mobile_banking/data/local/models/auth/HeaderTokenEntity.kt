package uz.gita.dima.mobile_banking.data.local.models.auth

data class HeaderTokenEntity(
    val refreshToken: String,
    val accessToken: String
)

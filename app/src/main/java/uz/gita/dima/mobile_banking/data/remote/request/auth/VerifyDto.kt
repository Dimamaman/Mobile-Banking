package uz.gita.dima.mobile_banking.data.remote.request.auth

data class VerifyDto(
    val token: String,
    val code: String
)
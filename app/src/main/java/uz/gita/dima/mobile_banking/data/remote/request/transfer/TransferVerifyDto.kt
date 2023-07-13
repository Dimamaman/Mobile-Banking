package uz.gita.dima.mobile_banking.data.remote.request.transfer

data class TransferVerifyDto(
    val token: String,
    val code: String
)

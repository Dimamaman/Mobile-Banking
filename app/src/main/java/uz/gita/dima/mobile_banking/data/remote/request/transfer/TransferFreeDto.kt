package uz.gita.dima.mobile_banking.data.remote.request.transfer

import com.google.gson.annotations.SerializedName

data class TransferFreeDto(
    @SerializedName("sender-id")
    val senderId: String,
    val receiver: String,
    val amount: Int
)

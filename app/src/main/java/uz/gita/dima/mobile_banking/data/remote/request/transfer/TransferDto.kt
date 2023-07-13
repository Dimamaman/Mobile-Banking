package uz.gita.dima.mobile_banking.data.remote.request.transfer

import com.google.gson.annotations.SerializedName

data class TransferDto(
    val type: String,
    @SerializedName(value = "sender-id")
    val senderId: String,
    @SerializedName(value = "receiver-pan")
    val receiverPan: String,
    val amount: Int
)

package uz.gita.dima.mobile_banking.data.remote.request.card

import com.google.gson.annotations.SerializedName

data class CardDto(
    val pan: String,
    @SerializedName(value = "expired-month")
    val expiredMonth: String,
    @SerializedName(value = "expired-year")
    val expiredYear: String,
    val name: String

)

package uz.gita.dima.mobile_banking.data.remote.request.user

import com.google.gson.annotations.SerializedName

data class UpdateUserDto(
    @SerializedName(value = "first-name")
    val firstName: String,
    @SerializedName(value = "last-name")
    val lastName: String,
    @SerializedName(value = "born-date")
    val bornDate: Long,
    @SerializedName(value = "gender-type")
    val gender: Int
)
package uz.gita.dima.mobile_banking.data.remote.response.user

import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName(value = "phone")
    val phone: String,
    @SerializedName(value = "first-name")
    val firstName: String,
    @SerializedName(value = "last-name")
    val lastName: String,
    @SerializedName(value = "born-date")
    val bornDate: Long,
    @SerializedName(value = "gender")
    val gender: Int
)

package uz.gita.dima.mobile_banking.data.remote.request.auth

import com.google.gson.annotations.SerializedName

data class UpdateTokenDto(
    @SerializedName(value = "refresh-token")
    val refreshToken: String
)

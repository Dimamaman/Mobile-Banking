package uz.gita.dima.mobile_banking.data.remote.response.auth

import com.google.gson.annotations.SerializedName

data class HeaderData(
    @SerializedName(value = "refresh-token")
    val refreshToken: String,
    @SerializedName(value = "access-token")
    val accessToken: String
)

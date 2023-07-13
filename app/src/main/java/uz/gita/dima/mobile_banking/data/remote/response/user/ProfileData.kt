package uz.gita.dima.mobile_banking.data.remote.response.user

import com.google.gson.annotations.SerializedName

data class ProfileData(
    @SerializedName(value = "first-name")
    val firstName: String,
    @SerializedName(value = "gender-type")
    val genderType: Int = 0,
    @SerializedName(value = "age")
    val age: Int
)

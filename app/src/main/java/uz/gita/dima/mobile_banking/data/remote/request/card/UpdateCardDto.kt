package uz.gita.dima.mobile_banking.data.remote.request.card

import com.google.gson.annotations.SerializedName

data class UpdateCardDto(
    val id:Int,
    val name:String,
    @SerializedName("theme-type")
    val themeType:Int,
    @SerializedName(value = "is-visible")
    val isVisible: Boolean,
)

package uz.gita.dima.mobile_banking.data.remote.response.transfer

import com.google.gson.annotations.SerializedName

data class TransferHistoryData(
    @SerializedName("total-elements")
    val totalElements: Int,
    @SerializedName("total-pages")
    val totalPages: Int,
    @SerializedName("current-page")
    val currentPage: Int,
    @SerializedName("child")
    val transfers: List<TransferData>
)

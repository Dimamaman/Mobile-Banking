package uz.gita.dima.mobile_banking.data.local.models.transfer

data class TransferHistoryEntity(
    val totalElements: Int,
    val totalPages: Int,
    val currentPage: Int,
    val transfers: List<TransferEntity>
)

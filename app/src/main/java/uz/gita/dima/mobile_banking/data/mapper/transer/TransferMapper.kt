package uz.gita.dima.mobile_banking.data.mapper.transer

import uz.gita.dima.mobile_banking.data.local.models.transfer.PanEntity
import uz.gita.dima.mobile_banking.data.local.models.transfer.TransferEntity
import uz.gita.dima.mobile_banking.data.local.models.transfer.TransferFreeEntity
import uz.gita.dima.mobile_banking.data.local.models.transfer.TransferHistoryEntity
import uz.gita.dima.mobile_banking.data.remote.response.transfer.PanData
import uz.gita.dima.mobile_banking.data.remote.response.transfer.TransferData
import uz.gita.dima.mobile_banking.data.remote.response.transfer.TransferFreeData
import uz.gita.dima.mobile_banking.data.remote.response.transfer.TransferHistoryData

fun PanData.toPanEntity(): PanEntity {
    return PanEntity(pan = pan)
}

fun TransferData.toTransferEntity(): TransferEntity {
    return TransferEntity(
        amount = amount,
        from = from,
        time = time,
        to = to,
        type = type
    )
}

fun TransferFreeData.toTransferFreeEntity(): TransferFreeEntity {
    return TransferFreeEntity(
        free = free,
        amount = amount
    )
}

fun TransferHistoryData.toTransferHistoryEntity(): TransferHistoryEntity {
    return TransferHistoryEntity(
        totalElements = totalElements,
        totalPages = totalPages,
        currentPage = currentPage,
        transfers = transfers.map { it.toTransferEntity() }
    )
}
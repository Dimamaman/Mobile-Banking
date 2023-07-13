package uz.gita.dima.mobile_banking.data.mapper.user

import uz.gita.dima.mobile_banking.data.local.models.transfer.LastTransferEntity
import uz.gita.dima.mobile_banking.data.local.models.user.BalanceEntity
import uz.gita.dima.mobile_banking.data.local.models.user.MessageEntity
import uz.gita.dima.mobile_banking.data.local.models.user.ProfileEntity
import uz.gita.dima.mobile_banking.data.local.models.user.UserEntity
import uz.gita.dima.mobile_banking.data.remote.response.user.BalanceData
import uz.gita.dima.mobile_banking.data.remote.response.user.LastTransferData
import uz.gita.dima.mobile_banking.data.remote.response.user.MessageData
import uz.gita.dima.mobile_banking.data.remote.response.user.ProfileData


fun BalanceData.toBalanceEntity(): BalanceEntity {
    return BalanceEntity(totalBalance = totalBalance)
}

fun LastTransferData.toLastTransferEntity(): LastTransferEntity {
    return LastTransferEntity(
        amount = amount,
        from = from,
        time = time,
        to = to,
        type = type
    )
}

fun MessageData.toMessageEntity(): MessageEntity {
    return MessageEntity(message = message)
}

fun ProfileData.toProfileEntity(): ProfileEntity {
    return ProfileEntity(
        firstName = firstName,
        genderType = genderType,
        age = age
    )
}

fun uz.gita.dima.mobile_banking.data.remote.response.user.UserData.toUserEntity(): UserEntity {
    return UserEntity(
        phone = phone,
        firstName = firstName,
        lastName = lastName,
        bornDate = bornDate,
        gender = gender
    )
}
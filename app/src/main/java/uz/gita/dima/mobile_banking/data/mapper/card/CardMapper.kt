package uz.gita.dima.mobile_banking.data.mapper.card

import uz.gita.dima.mobile_banking.data.local.models.card.CardEntity
import uz.gita.dima.mobile_banking.data.remote.response.card.CardData

fun CardData.toCardEntity(): CardEntity {
    return CardEntity(
        id = id,
        amount = amount,
        expiredMonth = expiredMonth,
        expiredYear = expiredYear,
        isVisible = isVisible,
        name = name,
        owner = owner,
        pan = pan,
        themeType = themeType
    )
}
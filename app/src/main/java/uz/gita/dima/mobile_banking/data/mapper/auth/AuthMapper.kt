package uz.gita.dima.mobile_banking.data.mapper.auth

import uz.gita.dima.mobile_banking.data.local.models.auth.HeaderTokenEntity
import uz.gita.dima.mobile_banking.data.local.models.auth.TokenEntity
import uz.gita.dima.mobile_banking.data.remote.response.auth.HeaderData
import uz.gita.dima.mobile_banking.data.remote.response.auth.TokenData

fun HeaderData.toHeaderEntity(): HeaderTokenEntity {
    return HeaderTokenEntity(
        refreshToken = refreshToken,
        accessToken = accessToken
    )
}

fun TokenData.toTokenEntity(): TokenEntity {
    return TokenEntity(token = token)
}
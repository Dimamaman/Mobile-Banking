package uz.gita.dima.mobile_banking.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.dima.mobile_banking.data.remote.response.auth.HeaderData
import uz.gita.dima.mobile_banking.data.remote.response.auth.TokenData
import uz.gita.dima.mobile_banking.utils.ResultData

interface AuthUseCase {

    fun login(phone: String, password: String): Flow<ResultData<TokenData>>

    fun loginVerify(code: String): Flow<ResultData<HeaderData>>

    fun register(
        phone: String,
        password: String,
        firstName: String,
        lastName: String,
        bornDate: Long,
        gender: Int
    ): Flow<ResultData<TokenData>>

    fun registerVerify(code: String): Flow<ResultData<HeaderData>>

    fun loginResendCode(): Flow<ResultData<TokenData>>

    fun registerResendCode(): Flow<ResultData<TokenData>>

    suspend fun setToken(token: String)

    suspend fun setAccessToken(accessToken: String)

    suspend fun setRefreshToken(refreshToken: String)

    suspend fun getToken(): String

    suspend fun getAccessToken(): String

    suspend fun getRefreshToken(): String
}
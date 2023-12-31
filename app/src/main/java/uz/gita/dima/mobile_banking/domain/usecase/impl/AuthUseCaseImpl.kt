package uz.gita.dima.mobile_banking.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.dima.mobile_banking.data.local.prefs.MySharedPrefs
import uz.gita.dima.mobile_banking.data.remote.request.auth.LoginDto
import uz.gita.dima.mobile_banking.data.remote.request.auth.RegisterDto
import uz.gita.dima.mobile_banking.data.remote.request.auth.TokenDto
import uz.gita.dima.mobile_banking.data.remote.request.auth.VerifyDto
import uz.gita.dima.mobile_banking.data.remote.response.auth.HeaderData
import uz.gita.dima.mobile_banking.data.remote.response.auth.TokenData
import uz.gita.dima.mobile_banking.domain.repository.AuthRepository
import uz.gita.dima.mobile_banking.domain.usecase.AuthUseCase
import uz.gita.dima.mobile_banking.utils.ResultData
import javax.inject.Inject

class AuthUseCaseImpl @Inject constructor(
    private val authRepository: AuthRepository,
    private val mySharedPrefs: MySharedPrefs
) : AuthUseCase {
    override fun login(phone: String, password: String): Flow<ResultData<TokenData>> =
        authRepository.login(LoginDto(password, phone))

    override fun register(
        phone: String,
        password: String,
        firstName: String,
        lastName: String,
        bornDate: Long,
        gender: Int
    ): Flow<ResultData<TokenData>> =
        authRepository.register(RegisterDto(phone, password, firstName, lastName, bornDate, gender))

    override fun loginVerify(code: String): Flow<ResultData<HeaderData>> =
        authRepository.loginVerify(VerifyDto(mySharedPrefs.tempToken, code))

    override fun registerVerify(code: String): Flow<ResultData<HeaderData>> =
        authRepository.registerVerify(VerifyDto(mySharedPrefs.tempToken, code))

    override fun loginResendCode(): Flow<ResultData<TokenData>> =
        authRepository.loginResendCode(TokenDto(mySharedPrefs.accessToken))

    override fun registerResendCode(): Flow<ResultData<TokenData>> =
        authRepository.registerResendCode(TokenDto(mySharedPrefs.accessToken))

    override suspend fun setToken(token: String) {
        mySharedPrefs.tempToken = token
    }

    override suspend fun setAccessToken(accessToken: String) {
        mySharedPrefs.accessToken = accessToken
    }

    override suspend fun setRefreshToken(refreshToken: String) {
        mySharedPrefs.refreshToken = refreshToken
    }

    override suspend fun getToken(): String =
        mySharedPrefs.tempToken

    override suspend fun getAccessToken(): String =
        mySharedPrefs.accessToken

    override suspend fun getRefreshToken(): String =
        mySharedPrefs.refreshToken
}
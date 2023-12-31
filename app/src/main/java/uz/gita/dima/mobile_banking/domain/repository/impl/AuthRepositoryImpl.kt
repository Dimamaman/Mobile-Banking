package uz.gita.dima.mobile_banking.domain.repository.impl

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.dima.mobile_banking.data.remote.api.AuthApi
import uz.gita.dima.mobile_banking.data.remote.request.auth.*
import uz.gita.dima.mobile_banking.data.remote.response.auth.HeaderData
import uz.gita.dima.mobile_banking.data.remote.response.auth.TokenData
import uz.gita.dima.mobile_banking.domain.repository.AuthRepository
import uz.gita.dima.mobile_banking.utils.ResultData
import uz.gita.dima.mobile_banking.utils.func
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val gson: Gson,
    private val api: AuthApi
) : AuthRepository {
    override fun register(registerDto: RegisterDto): Flow<ResultData<TokenData>> =
        flow {
            emit(api.register(registerDto).func(gson))
        }.catch { error -> emit(ResultData.Error(error)) }.flowOn(Dispatchers.IO)

    override fun login(loginDto: LoginDto): Flow<ResultData<TokenData>> = flow {
        emit(api.login(loginDto).func(gson))
    }.catch { error -> emit(ResultData.Error(error)) }.flowOn(Dispatchers.IO)

    override fun loginVerify(verifyDto: VerifyDto): Flow<ResultData<HeaderData>> = flow {
        emit(api.loginVerify(verifyDto).func(gson))
    }.catch { error -> emit(ResultData.Error(error)) }.flowOn(Dispatchers.IO)

    override fun registerVerify(verifyDto: VerifyDto): Flow<ResultData<HeaderData>> = flow {
        emit(api.registerVerify(verifyDto).func(gson))
    }.catch { error -> emit(ResultData.Error(error)) }.flowOn(Dispatchers.IO)

    override fun updateToken(updateTokenDto: UpdateTokenDto): Flow<ResultData<HeaderData>> = flow {
        emit(api.updateToken(updateTokenDto).func(gson))
    }.catch { error -> emit(ResultData.Error(error)) }.flowOn(Dispatchers.IO)

    override fun loginResendCode(tokenDto: TokenDto): Flow<ResultData<TokenData>> = flow {
        emit(api.loginResendCode(tokenDto).func(gson))
    }.catch { error -> emit(ResultData.Error(error)) }.flowOn(Dispatchers.IO)

    override fun registerResendCode(tokenDto: TokenDto): Flow<ResultData<TokenData>> = flow {
        emit(api.registerResendCode(tokenDto).func(gson))
    }.catch { error -> emit(ResultData.Error(error)) }.flowOn(Dispatchers.IO)
}
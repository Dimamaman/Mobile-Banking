package uz.gita.dima.mobile_banking.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.dima.mobile_banking.data.remote.request.user.UpdateUserDto
import uz.gita.dima.mobile_banking.data.remote.response.user.*
import uz.gita.dima.mobile_banking.utils.ResultData

interface UserRepository {

    fun getCurrentBalance(): Flow<ResultData<BalanceData>>

    fun getUserInfo(): Flow<ResultData<ProfileData>>

    fun getUserDetail(): Flow<ResultData<UserData>>

    fun updateUser(updateUserDto: UpdateUserDto): Flow<ResultData<MessageData>>

    fun getAllLastTransfers(): Flow<ResultData<List<LastTransferData>>>
}
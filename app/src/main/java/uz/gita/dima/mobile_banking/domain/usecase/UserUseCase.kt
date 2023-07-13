package uz.gita.dima.mobile_banking.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.dima.mobile_banking.data.remote.request.user.UpdateUserDto
import uz.gita.dima.mobile_banking.data.remote.response.user.*
import uz.gita.dima.mobile_banking.utils.ResultData

interface UserUseCase {

    suspend fun setFirstName(firstName: String)

    suspend fun setLastName(lastName: String)

    suspend fun setPhoneNumber(phoneNumber: String)

    suspend fun setPassword(password: String)

    suspend fun setBornDate(bornDate: Long)

    suspend fun setGender(gender: Int)

    suspend fun getFirstName(): String

    suspend fun getLastName(): String

    suspend fun getPhoneNumber(): String

    suspend fun getPassword(): String

    suspend fun getBornDate(): Long

    suspend fun getGender(): Int

    fun getCurrentBalance(): Flow<ResultData<BalanceData>>

    fun getUserInfo(): Flow<ResultData<ProfileData>>

    fun getUserDetail(): Flow<ResultData<UserData>>

    fun updateUser(updateUserDto: UpdateUserDto): Flow<ResultData<MessageData>>

    fun getAllLastTransfers(): Flow<ResultData<List<LastTransferData>>>

}
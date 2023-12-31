package uz.gita.dima.mobile_banking.data.remote.authenticator

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import uz.gita.dima.mobile_banking.data.local.prefs.MySharedPrefs
import uz.gita.dima.mobile_banking.data.remote.api.AuthApi
import uz.gita.dima.mobile_banking.data.remote.request.auth.UpdateTokenDto
import uz.gita.dima.mobile_banking.utils.func
import uz.gita.dima.mobile_banking.utils.getMessage
import uz.gita.dima.mobile_banking.utils.log

class TokenAuthenticator(
    private val authApi: AuthApi,
    private val mySharedPrefs: MySharedPrefs,
    private val gson: Gson
) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        getUpdateToken()
        return response.request().newBuilder()
            .header("Authorization", "Bearer ${mySharedPrefs.accessToken}")
            .build()
    }

    private fun getUpdateToken(): String {
        var token = ""
        runBlocking(Dispatchers.IO) {
            authApi.updateToken(UpdateTokenDto(mySharedPrefs.refreshToken)).func(gson).onSuccess {
                token = it.accessToken
                mySharedPrefs.accessToken = it.accessToken
                mySharedPrefs.refreshToken = it.refreshToken
            }.onMessage {
                println(it)
                log(it)
            }.onError {
                println(it.getMessage())
                log(it.getMessage())
            }
        }
        return token
    }

}
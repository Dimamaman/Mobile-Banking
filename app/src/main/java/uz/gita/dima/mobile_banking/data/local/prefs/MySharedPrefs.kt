package uz.gita.dima.mobile_banking.data.local.prefs

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import uz.gita.dima.mobile_banking.utils.SharedPreference
import javax.inject.Inject

class MySharedPrefs @Inject constructor(
    @ApplicationContext ctx: Context,
    sharedPreferences: SharedPreferences
) : SharedPreference(ctx, sharedPreferences) {

    var accessToken: String by Strings("")

    var refreshToken: String by Strings("")

    var tempToken: String by Strings("")

    var firstName: String by Strings("")

    var lastName: String by Strings("")

    var phoneNumber: String by Strings("")

    var password: String by Strings("")

    var bornDate: Long by Longs()

    var gender: Int by Ints(0)
}
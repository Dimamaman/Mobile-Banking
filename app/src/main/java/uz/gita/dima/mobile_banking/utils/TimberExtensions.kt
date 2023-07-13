package uz.gita.dima.mobile_banking.utils

import timber.log.Timber

fun log(message: String, tag: String = "TTT") {
    Timber.tag(tag).d(message)
}

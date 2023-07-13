package uz.gita.dima.mobile_banking.utils

fun Throwable.getMessage() = this.message ?: "Unknown error"

fun noInternetConnection(): Throwable = Throwable("No internet connection")
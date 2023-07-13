package uz.gita.dima.mobile_banking.utils

fun Int.getTimeFormat(): String {
    val min = this / 60
    val sec = this % 60
    val secString = if (sec < 10) "0$sec" else "$sec"
    return "0$min:$secString"
}
package uz.gita.dima.mobile_banking.utils

fun Double.getFinanceType(): String {
    return "$this".combine("sum")
}
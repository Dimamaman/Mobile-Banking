package uz.gita.dima.mobile_banking.utils

import androidx.viewbinding.ViewBinding

fun <T : ViewBinding> T.include(block: T.() -> Unit) {
    block(this)
}

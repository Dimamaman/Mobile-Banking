package uz.gita.dima.mobile_banking.presentation.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import uz.gita.dima.mobile_banking.databinding.DialogMessageBinding
import uz.gita.dima.mobile_banking.utils.config

class MessageDialog(ctx: Context, private val message: String): Dialog(ctx) {
    private lateinit var binding: DialogMessageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = DialogMessageBinding.inflate(layoutInflater)
        config(binding)
        binding.tvMessage.text = message

        binding.btnCancel.setOnClickListener {
            dismiss()
        }
    }
}
package uz.gita.dima.mobile_banking.presentation.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import uz.gita.dima.mobile_banking.databinding.DialogChooseDateBinding
import uz.gita.dima.mobile_banking.utils.config
import java.util.Calendar
import java.util.Date

class ChooseDateDialog(cxt: Context, private val date: Date) : Dialog(cxt) {
    private lateinit var binding: DialogChooseDateBinding

    private var confirmClickListener: ((Date) -> Unit)? = null

    fun setConfirmClickListener(block: (Date) -> Unit) {
        confirmClickListener = block
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = DialogChooseDateBinding.inflate(layoutInflater)
        config(binding)

        binding.btnCancel.setOnClickListener {
            dismiss()
        }

        val cal = Calendar.getInstance()
        cal.time = date

        val day = cal.get(Calendar.DAY_OF_MONTH)
        val month = cal.get(Calendar.MONTH)
        val year = cal.get(Calendar.YEAR)

        binding.calendarView.updateDate(year, month, day)
        binding.btnSave.setOnClickListener {
            val dayOfMonth = binding.calendarView.dayOfMonth
            val monthOfYear = binding.calendarView.month
            val currentYear = binding.calendarView.year
            cal.set(currentYear, monthOfYear, dayOfMonth)
            confirmClickListener?.invoke(cal.time)
            dismiss()
        }
    }
}
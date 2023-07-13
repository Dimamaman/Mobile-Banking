package uz.gita.dima.mobile_banking.presentation.ui.payment.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.dima.mobile_banking.R
import uz.gita.dima.mobile_banking.databinding.ListItemPaymentsLinearBinding
import uz.gita.dima.mobile_banking.domain.models.enums.PaymentType
import uz.gita.dima.mobile_banking.utils.getOrderString
import uz.gita.dima.mobile_banking.utils.include
import uz.gita.dima.mobile_banking.utils.inflate

val paymentItemCallback = object : DiffUtil.ItemCallback<PaymentType>() {
    override fun areItemsTheSame(oldItem: PaymentType, newItem: PaymentType): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: PaymentType, newItem: PaymentType): Boolean =
        oldItem.icon == newItem.icon

}

class PaymentLinearAdapter :
    ListAdapter<PaymentType, PaymentLinearAdapter.ViewHolder>(paymentItemCallback) {

    private var itemClickListener: ((PaymentType) -> Unit)? = null

    fun setItemClickListener(block: (PaymentType) -> Unit) {
        itemClickListener = block
    }

    inner class ViewHolder(private val binding: ListItemPaymentsLinearBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
             itemClickListener?.invoke(getItem(absoluteAdapterPosition))
            }
        }

        fun onBind() = binding.include {
            val data = getItem(absoluteAdapterPosition)
            tvPayment.text = data.name.getOrderString()
            imagePayment.setImageResource(data.icon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ListItemPaymentsLinearBinding.bind(parent.inflate(R.layout.list_item_payments_linear)))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind()

}



package uz.gita.dima.mobile_banking.presentation.ui.home.pages.accounts.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.dima.mobile_banking.R
import uz.gita.dima.mobile_banking.data.remote.response.user.LastTransferData
import uz.gita.dima.mobile_banking.databinding.ListItemLastTransfersBinding
import uz.gita.dima.mobile_banking.utils.combine
import uz.gita.dima.mobile_banking.utils.include
import uz.gita.dima.mobile_banking.utils.inflate
import uz.gita.dima.mobile_banking.utils.maskWatcher

class LastTransfersAdapter :
    ListAdapter<LastTransferData, LastTransfersAdapter.ViewHolder>(lastTransferItemCallback) {

    private var itemClickListener: ((LastTransferData) -> Unit)? = null

    fun setItemClickListener(block: (LastTransferData) -> Unit) {
        itemClickListener = block
    }

    inner class ViewHolder(private val binding: ListItemLastTransfersBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                itemClickListener?.invoke(getItem(absoluteAdapterPosition))
            }
        }

        fun onBind() = binding.include {
            val data = getItem(absoluteAdapterPosition)
            tvTransferWhere.text = data.to.maskWatcher(4,' ')
            tvType.text = data.type
            tvAmount.text = data.amount.toString().maskWatcher(3,' ').combine("sum")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ListItemLastTransfersBinding.bind(parent.inflate(R.layout.list_item_last_transfers)))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind()
}

private val lastTransferItemCallback = object : DiffUtil.ItemCallback<LastTransferData>() {
    override fun areItemsTheSame(oldItem: LastTransferData, newItem: LastTransferData): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: LastTransferData, newItem: LastTransferData): Boolean =
        oldItem == newItem

}
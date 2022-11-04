package br.com.android.partyapp.ui.adapter.listitemsadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.android.partyapp.data.model.TypeItem
import br.com.android.partyapp.databinding.InnerRecyclerListItemBinding

class InnerListItemsAdapter : RecyclerView.Adapter<InnerListItemsAdapter.InnerListItemsVH>() {

    private val data = mutableListOf<TypeItem>()

    fun setData(list: List<TypeItem>) {
        this.data.clear()
        this.data.addAll(list)
        notifyDataSetChanged()
    }

    inner class InnerListItemsVH(val binding: InnerRecyclerListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TypeItem) = binding.run {
            binding.title.text = item.title
            binding.quantity.text = item.quantity.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = InnerListItemsVH(
        InnerRecyclerListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: InnerListItemsVH, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size
}
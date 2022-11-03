package br.com.android.partyapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.android.partyapp.data.model.TypeItem
import br.com.android.partyapp.data.model.TypeItems
import br.com.android.partyapp.databinding.InnerRecyclerItemBinding
import br.com.android.partyapp.databinding.ItemsPartyAdapterBinding

class InnerPartyAdapter(
    private val onItemClicked: (TypeItem) -> Unit
) : RecyclerView.Adapter<InnerPartyAdapter.PartyAdapterVH>() {

    private val data = mutableListOf<TypeItem>()

    fun setData(list: List<TypeItem>) {
        this.data.clear()
        this.data.addAll(list)
        notifyDataSetChanged()
    }

    inner class PartyAdapterVH(val binding: InnerRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TypeItem) = binding.run {
            txvItem.text = item.title
            viewSelect.setOnClickListener {
                checkbox.isChecked = !checkbox.isChecked
                item.selected = checkbox.isChecked
                onItemClicked.invoke(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PartyAdapterVH(
        InnerRecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: PartyAdapterVH, position: Int) {

        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

}
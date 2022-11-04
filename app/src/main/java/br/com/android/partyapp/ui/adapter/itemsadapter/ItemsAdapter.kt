package br.com.android.partyapp.ui.adapter.itemsadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.android.partyapp.data.model.TypeItem
import br.com.android.partyapp.data.model.TypeItems
import br.com.android.partyapp.databinding.ItemsPartyAdapterBinding

class ItemsAdapter(
    private val onItemClicked: (TypeItem?) -> Unit
) : RecyclerView.Adapter<ItemsAdapter.ItemsVH>() {

    private val data = mutableListOf<TypeItems>()

    private lateinit var adapterParty: InnerItemsAdapter

    fun setData(list: List<TypeItems>) {
        this.data.clear()
        this.data.addAll(list)
        notifyDataSetChanged()
    }

    inner class ItemsVH(val binding: ItemsPartyAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TypeItems) = binding.run {
            title.text = item.title
            adapterParty = InnerItemsAdapter {
                onItemClicked(it)
            }
            recycler.adapter = adapterParty
            adapterParty.setData(item.items)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemsVH(
        ItemsPartyAdapterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ItemsVH, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size
}
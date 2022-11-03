package br.com.android.partyapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.android.partyapp.data.model.TypeItem
import br.com.android.partyapp.data.model.TypeItems
import br.com.android.partyapp.databinding.ItemsPartyAdapterBinding

class ItemsPartyAdapter(
    private val onItemClicked: (TypeItem?) -> Unit
) : RecyclerView.Adapter<ItemsPartyAdapter.ItemPartyVH>() {

    private val data = mutableListOf<TypeItems>()

    private lateinit var adapterParty: InnerPartyAdapter

    fun setData(list: List<TypeItems>) {
        this.data.clear()
        this.data.addAll(list)
        notifyDataSetChanged()
    }

    inner class ItemPartyVH(val binding: ItemsPartyAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TypeItems) = binding.run {
            title.text = item.title
            adapterParty = InnerPartyAdapter {
                onItemClicked(it)
            }
            recycler.adapter = adapterParty
            adapterParty.setData(item.items)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemPartyVH(
        ItemsPartyAdapterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ItemPartyVH, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size
}
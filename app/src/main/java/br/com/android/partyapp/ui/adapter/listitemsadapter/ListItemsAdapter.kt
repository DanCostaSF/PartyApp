package br.com.android.partyapp.ui.adapter.listitemsadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.android.partyapp.data.model.TypeItems
import br.com.android.partyapp.databinding.ListItemAdapterBinding

class ListItemsAdapter : RecyclerView.Adapter<ListItemsAdapter.ListItemAdapterVH>() {

    private val data = mutableListOf<TypeItems>()

    private lateinit var adapterListItems: InnerListItemsAdapter

    fun setData(list: List<TypeItems>) {
        this.data.clear()
        this.data.addAll(list)
        notifyDataSetChanged()
    }

   inner class ListItemAdapterVH(val binding: ListItemAdapterBinding) :
           RecyclerView.ViewHolder(binding.root) {
                fun bind(item: TypeItems) = binding.run {
                    title.text = item.title
                    adapterListItems = InnerListItemsAdapter()
                    recycler.adapter = adapterListItems
                    adapterListItems.setData(item.items)
                }
           }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ListItemAdapterVH(
        ListItemAdapterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ListItemAdapterVH, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size
}
package br.com.android.partyapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import br.com.android.partyapp.R
import br.com.android.partyapp.commons.BaseFragment
import br.com.android.partyapp.commons.observeAndNavigateBack
import br.com.android.partyapp.databinding.FragmentListItemsBinding
import br.com.android.partyapp.ui.adapter.listitemsadapter.ListItemsAdapter
import br.com.android.partyapp.ui.viewmodel.ItemsViewModel
import br.com.android.partyapp.ui.viewmodel.ListItemViewModel

class ListItemsFragment : BaseFragment<FragmentListItemsBinding>(
    R.layout.fragment_list_items
) {

    private val listItemViewModel: ListItemViewModel by activityViewModels()
    private val itemsViewModel: ItemsViewModel by activityViewModels()
    private lateinit var adapter: ListItemsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
    }

    private fun setupRecycler() {
        adapter = ListItemsAdapter()
        binding.recycler.adapter = adapter
    }

    override fun setupViewModel() {
        binding.vm = listItemViewModel
    }

    override fun setupObservers() {
        observeAndNavigateBack(listItemViewModel.onNavigateBack)

        itemsViewModel.listTypes.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        listItemViewModel.doneNavigateBack()
    }
}
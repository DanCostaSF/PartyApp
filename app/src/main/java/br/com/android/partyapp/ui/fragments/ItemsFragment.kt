package br.com.android.partyapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import br.com.android.partyapp.R
import br.com.android.partyapp.commons.BaseFragment
import br.com.android.partyapp.commons.navTo
import br.com.android.partyapp.commons.observeAndNavigateBack
import br.com.android.partyapp.databinding.FragmentItemsBinding
import br.com.android.partyapp.ui.adapter.itemsadapter.ItemsAdapter
import br.com.android.partyapp.ui.viewmodel.ViewModel

class ItemsFragment : BaseFragment<FragmentItemsBinding>(
    R.layout.fragment_items
) {

    private val itemsViewModel: ViewModel by activityViewModels()

    private lateinit var adapter: ItemsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        setupNextButton()
    }

    private fun setupNextButton() {
        binding.nextButton.setOnClickListener {
            navTo(ItemsFragmentDirections.actionItemsFragmentToListItemsFragment())
        }
    }

    private fun setupRecycler() {
        adapter = ItemsAdapter {
            it?.let {
                itemsViewModel.setSelectedItems(it)
            }
        }
        binding.recycler.adapter = adapter
    }

    override fun setupViewModel() {
        binding.vm = itemsViewModel
    }

    override fun setupObservers() {
        observeAndNavigateBack(itemsViewModel.onNavigateBack)
        itemsViewModel.listTypes.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        itemsViewModel.doneNavigateBack()
    }
}
package br.com.android.partyapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import br.com.android.partyapp.R
import br.com.android.partyapp.commons.BaseFragment
import br.com.android.partyapp.databinding.FragmentListItemsBinding
import br.com.android.partyapp.ui.viewmodel.PartyViewModel

class ListItemsFragment : BaseFragment<FragmentListItemsBinding>(
    R.layout.fragment_list_items
) {

    private val viewModel: PartyViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setupViewModel() {
        binding.vm = viewModel
    }

    override fun setupObservers() {

    }
}
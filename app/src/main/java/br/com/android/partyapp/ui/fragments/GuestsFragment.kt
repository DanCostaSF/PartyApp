package br.com.android.partyapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import br.com.android.partyapp.R
import br.com.android.partyapp.commons.BaseFragment
import br.com.android.partyapp.commons.navTo
import br.com.android.partyapp.commons.observeAndNavigateBack
import br.com.android.partyapp.databinding.FragmentGuestsBinding
import br.com.android.partyapp.ui.viewmodel.PartyViewModel

class GuestsFragment : BaseFragment<FragmentGuestsBinding>(
    R.layout.fragment_guests
) {

    private val viewModel: PartyViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupNextButton()
    }

    private fun setupNextButton() {
        binding.nextButton.setOnClickListener {
            navTo(GuestsFragmentDirections.actionGuestsFragmentToItemsFragment())
        }
    }

    override fun setupViewModel() {
        binding.vm = viewModel
    }

    override fun setupObservers() {
    }
}
package br.com.android.partyapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import br.com.android.partyapp.R
import br.com.android.partyapp.commons.BaseFragment
import br.com.android.partyapp.commons.navTo
import br.com.android.partyapp.databinding.FragmentGuestsBinding
import br.com.android.partyapp.ui.viewmodel.ViewModel

class GuestsFragment : BaseFragment<FragmentGuestsBinding>(
    R.layout.fragment_guests
) {

    private val viewModel: ViewModel by activityViewModels()

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

    override fun setupObservers() {}
}
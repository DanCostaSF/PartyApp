package br.com.android.partyapp.commons

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

@BindingAdapter("isVisible")
fun View.isVisible(visible: Boolean?) {
    visibility = if (visible == true) View.VISIBLE else View.INVISIBLE
}

fun Fragment.navTo(directions: NavDirections) = findNavController().navigate(directions)
fun Fragment.navBack() = findNavController().navigateUp()

fun Fragment.observeAndNavigateBack(livedata: LiveData<Boolean>) {
    livedata.observe(viewLifecycleOwner) {
        if (it == true) navBack()
    }
}
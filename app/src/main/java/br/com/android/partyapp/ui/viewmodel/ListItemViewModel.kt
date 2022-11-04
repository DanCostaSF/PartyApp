package br.com.android.partyapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.android.partyapp.data.model.TypeItems


class ListItemViewModel : ViewModel() {

    val onNavigateBack = MutableLiveData(false)

    fun doneNavigateBack() {
        onNavigateBack.value = false
    }

    fun onNavigationClick() {
        onNavigateBack.postValue(true)
    }

}
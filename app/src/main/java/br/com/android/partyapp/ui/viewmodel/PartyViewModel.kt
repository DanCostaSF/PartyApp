package br.com.android.partyapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PartyViewModel : ViewModel() {
    val mansValue = MutableLiveData(0)
    val womansValue = MutableLiveData(0)
    val childrensValue = MutableLiveData(0)

    val onNavigateBack = MutableLiveData(false)

    fun doneNavigateBack() {
        onNavigateBack.value = false
    }

    fun onNavigationClick() {
        onNavigateBack.postValue(true)
    }
}
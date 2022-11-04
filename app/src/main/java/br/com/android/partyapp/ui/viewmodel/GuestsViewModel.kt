package br.com.android.partyapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GuestsViewModel : ViewModel() {
    val mansValue = MutableLiveData(0)
    val womansValue = MutableLiveData(0)
    val childrensValue = MutableLiveData(0)

}
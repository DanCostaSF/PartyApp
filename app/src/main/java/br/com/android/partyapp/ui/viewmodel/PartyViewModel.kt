package br.com.android.partyapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.android.partyapp.data.model.TypeItem
import br.com.android.partyapp.data.model.TypeItems

class PartyViewModel : ViewModel() {

    val mansValue = MutableLiveData(0)
    val womansValue = MutableLiveData(0)
    val childrensValue = MutableLiveData(0)

    val listTypes = MutableLiveData<List<TypeItems>>()

    val listSelected = MutableLiveData<List<TypeItem>>()

    private val list = mutableListOf<TypeItem>()

    private val types = listOf(
        TypeItems(
            "Bolo",
            listOf(
                TypeItem("Prestígio", 1),
                TypeItem("Maracujá", 2),
                TypeItem("Morango", 3)
            )
        ),
        TypeItems(
            "Salgados",
            listOf(
                TypeItem("Coxinha", 4),
                TypeItem("Kibe", 5),
                TypeItem("Esfirra", 6)
            )
        )
    )

    init {
        setList(types)
    }

    private fun setList(list: List<TypeItems>) {
        listTypes.postValue(list)
    }

    fun setSelectedItems(item: TypeItem) {
        val listfiltered = list.filter {
             item.uid == it.uid
        }

        if (listfiltered.isNotEmpty()) {
            list.remove(listfiltered.first())
        }

        list.add(item)
        listSelected.postValue(list)
        Log.i("teste2", "$list")
    }

    val onNavigateBack = MutableLiveData(false)

    fun doneNavigateBack() {
        onNavigateBack.value = false
    }

    fun onNavigationClick() {
        onNavigateBack.postValue(true)
    }
}
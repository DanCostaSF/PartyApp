package br.com.android.partyapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.android.partyapp.data.model.TypeItem
import br.com.android.partyapp.data.model.TypeItems

class ViewModel : ViewModel() {

    var mansValue = 0
    var womansValue = 0
    var childrensValue = 0

    val onNavigateBack = MutableLiveData(false)

    fun doneNavigateBack() {
        onNavigateBack.value = false
    }

    fun onNavigationClick() {
        onNavigateBack.postValue(true)
    }

    val onNavigateBack2 = MutableLiveData(false)

    fun doneNavigateBack2() {
        onNavigateBack2.value = false
    }

    fun onNavigationClick2() {
        onNavigateBack2.postValue(true)
    }

    val listTypes = MutableLiveData<List<TypeItems>>()

    private val types = listOf(
        TypeItems(
            title = "Bolo", items = listOf(
                TypeItem(
                    title = "Prestígio", uid = 1, uidGroup = 1
                ), TypeItem(
                    title = "Maracujá", uid = 2, uidGroup = 1
                ), TypeItem(
                    title = "Morango", uid = 3, uidGroup = 1
                )
            ), uid = 1
        ), TypeItems(
            title = "Salgados", items = listOf(
                TypeItem(
                    title = "Coxinha", uid = 4, uidGroup = 2
                ), TypeItem(
                    title = "Kibe", uid = 5, uidGroup = 2
                ), TypeItem(
                    title = "Esfirra", uid = 6, uidGroup = 2
                )
            ), uid = 2
        )
    )

    init {
        setList(types)
    }

    private fun setList(list: List<TypeItems>) {
        listTypes.postValue(list)
    }

    fun setSelectedItems(item: TypeItem) {
        val handleType = types
        for (type in handleType) {
            for (typeItem in type.items) {
                if (typeItem.uid == item.uid) {
                    typeItem.selected = item.selected
                    when (typeItem.uidGroup) {
                        1 -> {
                            calcGroup1(typeItem)
                        }
                        2 -> {
                            calcGroup2(typeItem)
                        }
                    }
                }
            }
        }
        listTypes.postValue(handleType)
    }

    private fun calcGroup1(typeItem: TypeItem) {
        if (!typeItem.selected) {
            typeItem.quantity = 0
        } else {
            typeItem.quantity = (mansValue * 3) + (womansValue * 2)+ childrensValue
        }
    }

    private fun calcGroup2(typeItem: TypeItem) {
        if (!typeItem.selected) {
            typeItem.quantity = 0
        } else {
            typeItem.quantity = (mansValue * 10) + (womansValue *7) + (childrensValue * 5)
        }
    }
}
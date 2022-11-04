package br.com.android.partyapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.android.partyapp.data.model.TypeItem
import br.com.android.partyapp.data.model.TypeItems

class ItemsViewModel : ViewModel() {

    private val mansValue = MutableLiveData(0)
    private val womansValue = MutableLiveData(0)
    private val childrensValue = MutableLiveData(0)

    val onNavigateBack = MutableLiveData(false)

    fun doneNavigateBack() {
        onNavigateBack.value = false
    }

    fun onNavigationClick() {
        onNavigateBack.postValue(true)
    }

    val listTypes = MutableLiveData<List<TypeItems>>()

    fun postManValue(value: Int) {
        mansValue.postValue(value)
    }

    fun postWomanValue(value: Int) {
        womansValue.postValue(value)
    }

    fun postChildrenValue(value: Int) {
        childrensValue.postValue(value)
    }

    private val types = listOf(
        TypeItems(
            title = "Bolo",
            items = listOf(
                TypeItem(
                    title = "Prestígio",
                    uid = 1,
                    uidGroup = 1
                ),
                TypeItem(
                    title = "Maracujá",
                    uid = 2,
                    uidGroup = 1
                ),
                TypeItem(
                    title = "Morango",
                    uid = 3,
                    uidGroup = 1
                )
            ),
            uid = 1
        ),
        TypeItems(
            title = "Salgados",
            items = listOf(
                TypeItem(
                    title = "Coxinha",
                    uid = 4,
                    uidGroup = 2
                ),
                TypeItem(
                    title = "Kibe",
                    uid = 5,
                    uidGroup = 2
                ),
                TypeItem(
                    title = "Esfirra",
                    uid = 6,
                    uidGroup = 2
                )
            ),
            uid = 2
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
        for(type in handleType) {
            for(typeItem in type.items){
                if(typeItem.uid == item.uid){
                    typeItem.selected = item.selected
                    when(typeItem.uidGroup) {
                        1 -> typeItem.quantity = (mansValue.value?.times(1))?.plus(womansValue.value?.times(2)!!)
                    }
                }
            }
        }
        listTypes.postValue(handleType)
    }
}
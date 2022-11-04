package br.com.android.partyapp.data.model

data class TypeItem(
    val title: String,
    val uid: Int,
    val uidGroup: Int,
    var quantity: Int? = 0,
    var selected: Boolean = false
)
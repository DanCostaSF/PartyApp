package br.com.android.partyapp.ui.components.seekbarcustom

import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener

@BindingAdapter("app:value_item")
fun SeekBarCustom.setValueItemChanged(
    value: Int?
) {
    value?.let {
        value_seek = it
        valueSeek.value = it
    }
}

@InverseBindingAdapter(attribute = "app:value_item", event = "app:itemValueChanged")
fun SeekBarCustom.getValueItemChanged(): Int = valueSeek.value ?: 0

@BindingAdapter("app:itemValueChanged")
fun SeekBarCustom.setListener (
    attrChange: InverseBindingListener
) {
    valueCallback = {
        attrChange.onChange()
    }
}
package br.com.android.partyapp.ui.components.seekbarcustom

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.SeekBar
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.android.partyapp.R
import br.com.android.partyapp.databinding.SeekBarCustomBinding

class SeekBarCustom @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    private val defStyle: Int = 0,
) : ConstraintLayout(context, attrs, defStyle) {

    private val binding = SeekBarCustomBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    var value_seek: Int? = null
        set(value) {
            binding.textSeekValue.text = "($value)"
            field = value
        }

    var type_seek: String? = null
        set(value) {
            binding.textSeekLabel.text = value
            field = value
        }

    var valueCallback: (() -> Unit)? = null

    init {
        setupAttr()
        setupButtonProgress()
    }

    private fun setupAttr() {
        val style = context.obtainStyledAttributes(
            attrs, R.styleable.SeekBarCustom, defStyle, 0
        )
        updateParamValues(style)
        setupSeekBar()

    }

    private fun setupSeekBar() {
        setupProgressChanged()
    }

    @SuppressLint("NewApi")
    private fun setupButtonProgress() {
        binding.plusButton.setOnClickListener {
            value_seek?.let { value ->
                if (value < binding.seekBar.max) {
                    value_seek = value_seek?.plus(1)
                    value_seek?.let {
                        binding.seekBar.progress = it
                    }
                }
            }
        }

        binding.minusButton.setOnClickListener {
            value_seek?.let { value ->
                if (value > binding.seekBar.min) {
                    value_seek = value_seek?.minus(1)
                    value_seek?.let {
                        binding.seekBar.progress = it
                    }
                }
            }
        }
    }

    private fun setupProgressChanged() {
        binding.seekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                value_seek = p0?.progress
                valueCallback?.invoke()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {
                value_seek = p0?.progress
                valueCallback?.invoke()
            }
        })
    }

    private fun updateParamValues(style: TypedArray) {
        value_seek = style.getInt(R.styleable.SeekBarCustom_value_seek, 0)
        type_seek = style.getString(R.styleable.SeekBarCustom_type_seek)
    }
}
package com.np.mycustomviews.segment_controller

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat.getColor
import androidx.core.content.ContextCompat.getDrawable
import com.google.android.material.button.MaterialButton
import com.np.mycustomviews.R

class Segment @JvmOverloads constructor(context: Context, private val attrs: AttributeSet? = null) : MaterialButton(context, attrs) {

    private lateinit var materialButton: MaterialButton
    private lateinit var typedArray: TypedArray

    var label: String? = null
        get() {
            return materialButton.text.toString()
        }
        set(value) {
            field = value
            materialButton.text = field
        }


    init {
        initializeViews()
        setValues()
    }

    private fun initializeViews() {
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.Segment)
        val view = View.inflate(context, R.layout.segment, null)
        materialButton = view.findViewById(R.id.material_button)
        materialButton.setTextColor(getColor(context, R.color.white))
        materialButton.icon = getDrawable(context, R.drawable.ic_arrow)
    }

    private fun setValues(){
        try {
            materialButton.text = typedArray.getString(R.styleable.Segment_segmentLabel)
        } finally {
            typedArray.recycle()
        }
    }

}
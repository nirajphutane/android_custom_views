package com.np.mycustomviews.segment_controller

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat.getColor
import androidx.core.content.ContextCompat.getDrawable
import com.google.android.material.button.MaterialButton
import com.np.mycustomviews.R

class SingleSegment @JvmOverloads constructor(context: Context, private val attrs: AttributeSet? = null) : MaterialButton(context, attrs) {

    var label: String? = null
        get() {
            return text.toString()
        }
        set(value) {
            field = value
            text = field
        }

    init {
        initializeViews()
    }

    private fun initializeViews() {
        lateinit var typedArray: TypedArray
        try {
            typedArray = context.obtainStyledAttributes(attrs, R.styleable.SingleSegment)
            text = typedArray.getString(R.styleable.Segment_segmentLabel)
            icon = getDrawable(context, R.drawable.ic_arrow)
        } finally {
            typedArray.recycle()
        }
    }
}
package com.np.mycustomviews.segment_controller

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.google.android.material.button.MaterialButtonToggleGroup
import com.np.mycustomviews.R

class SegmentController @JvmOverloads constructor(context: Context, private val attrs: AttributeSet? = null) : MaterialButtonToggleGroup(context, attrs) {

    private lateinit var materialButtonToggleGroup: MaterialButtonToggleGroup

    init {
        initializeViews()
    }

    private fun initializeViews() {
        val view = View.inflate(context, R.layout.segment_controller, null)
        materialButtonToggleGroup = view.findViewById(R.id.material_button_toggle_group)
    }
}
package com.np.mycustomviews.quick_action_view

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import com.np.mycustomviews.R
import com.np.mycustomviews.R.styleable.*

class QuickActionView @JvmOverloads constructor(context: Context, private val attrs: AttributeSet? = null) : LinearLayout(context, attrs), View.OnClickListener {

    var listener: OnClickListener? = null

    var label: String? = null
        set(value) {
            field = value
            textView.text = field
        }

    @DrawableRes
    var src: Int? = null
        set(value) {
            field = value
            setImage(field ?: 0)
        }

    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    private lateinit var typedArray: TypedArray

    init {
        initializeViews()
        setValues()
    }

    private fun initializeViews() {
        val view = View.inflate(context, R.layout.quick_action, this)
        imageView = view.findViewById(R.id.image_view)
        textView = view.findViewById(R.id.text_view)
        typedArray = context.obtainStyledAttributes(attrs, QuickActionView)
    }

    private fun setValues(){
        try {
            textView.text = typedArray.getString(QuickActionView_label)
            setImage(typedArray.getResourceId(QuickActionView_src, 0))
        } finally {
            typedArray.recycle()
        }
    }

    private fun setImage(@DrawableRes drawableId: Int){
        if (drawableId != 0) {
            val drawable = AppCompatResources.getDrawable(context, drawableId)
            imageView.setImageDrawable(drawable)
        }
    }

    fun setOnClickListener(callback: () -> Unit) {
       imageView.setOnClickListener {
           callback()
       }
    }

    override fun onClick(v: View?) {
        listener?.let {
            listener!!.onClick(v);
        }
    }
}
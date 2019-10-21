package com.app.roomy.util.customViews.preLolipopViews.TextView

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.AppCompatTextView
import com.app.roomy.R


class PreLollipopTextView : AppCompatTextView {
    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val attributeArray = context.obtainStyledAttributes(attrs, R.styleable.PreLollipopTextView)
        initAttrs(context, attributeArray)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        val attributeArray = context.obtainStyledAttributes(attrs, R.styleable.PreLollipopTextView)
        initAttrs(context, attributeArray)

    }


    private fun initAttrs(context: Context, attributeArray: TypedArray) {
        var drawableLeft: Drawable? = null
        var drawableRight: Drawable? = null
        var drawableBottom: Drawable? = null
        var drawableTop: Drawable? = null
        //============================================================================================
        if (Build.VERSION.SDK_INT >= 21) {
            drawableLeft = attributeArray.getDrawable(1)
            drawableRight = attributeArray.getDrawable(2)
            drawableBottom = attributeArray.getDrawable(0)
            drawableTop = attributeArray.getDrawable(3)
        } else {
            val drawableLeftId = attributeArray.getResourceId(1, -1)
            val drawableRightId = attributeArray.getResourceId(2, -1)
            val drawableBottomId = attributeArray.getResourceId(0, -1)
            val drawableTopId = attributeArray.getResourceId(3, -1)
            if (drawableLeftId != -1) {
                drawableLeft = AppCompatResources.getDrawable(context, drawableLeftId)
            }
            if (drawableRightId != -1) {
                drawableRight = AppCompatResources.getDrawable(context, drawableRightId)
            }
            if (drawableBottomId != -1) {
                drawableBottom = AppCompatResources.getDrawable(context, drawableBottomId)
            }
            if (drawableTopId != -1) {
                drawableTop = AppCompatResources.getDrawable(context, drawableTopId)
            }
        }

        setCompoundDrawablesWithIntrinsicBounds(
            drawableLeft,
            drawableTop,
            drawableRight,
            drawableBottom
        )
        attributeArray.recycle()

    }
}
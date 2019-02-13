package com.gm.settingsapp.ui.customview


import android.content.Context
import android.graphics.Canvas
import androidx.appcompat.widget.AppCompatTextView
import android.util.AttributeSet
import android.view.View
import com.gm.settingsapp.R
import java.lang.Math.PI

/**
 * Customising the AppCompatTextView for Skew display format
 */
class SkewTextView : AppCompatTextView {

    var degree: Float = 0.toFloat()
    var tan: Float = 0.toFloat()
    private var angle: Float = 0.toFloat()
    internal var pie = PI
    private var mContext: Context? = null

    constructor(context: Context) : super(context) {
        mContext = context
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        mContext = context

        val a = context.theme.obtainStyledAttributes(attrs, R.styleable.SkewTextView, 0, 0)

        try {
            // Getting attributes.


            degree = a.getFloat(R.styleable.SkewTextView_slopedAngle, 0f)

            setAngle(degree)
        } finally {
            a.recycle()
        }
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        mContext = context
    }

    override fun onDraw(canvas: Canvas) {
        if (mContext!!.resources.configuration.layoutDirection == View.LAYOUT_DIRECTION_RTL) {
            //in Right To Left layout
            degree = -tan
            canvas.skew(-tan, 0f)
        } else {
            degree = tan
            canvas.skew(tan, 0f)
        }

        super.onDraw(canvas)
    }

    /**
     * Skew Angle for AppCompatTextView
     * @param degree skew angle
     */

    fun setAngle(degree: Float) {
        tan = Math.tan(degree * pie / 180).toFloat()
        android.util.Log.v("SkewTextView", "tan::" + tan + "degree" + degree)
        angle = degree
        invalidate()
    }

}

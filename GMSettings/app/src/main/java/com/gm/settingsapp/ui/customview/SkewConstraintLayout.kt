package com.gm.settingsapp.ui.customview

import android.content.Context
import android.graphics.Canvas
import androidx.constraintlayout.widget.ConstraintLayout
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.gm.settingsapp.R

import java.lang.Math.PI

/**
 * Customising the ConstraintLayout for Skew display format
 */
class SkewConstraintLayout : ConstraintLayout {

    var degree: Float = 0.toFloat()
    var tan: Float = 0.toFloat()
    private var mContext: Context? = null

    private var angle: Float = 0.toFloat()
    internal var pie = PI

    private var x1: Float = 0.toFloat()
    private var w: Float = 0.toFloat()

    private var y1: Float = 0.toFloat()
    private var h: Float = 0.toFloat()

    private var touchedX: Float = 0.toFloat()
    private var touchedY: Float = 0.toFloat()
    //private PaintFlagsDrawFilter mFilter;

    constructor(context: Context) : super(context) {
        mContext = context
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        mContext = context

        val a = context.theme.obtainStyledAttributes(attrs, R.styleable.SkewConstraintLayout, 0, 0)

        try {


            degree = a.getFloat(R.styleable.SkewConstraintLayout_slopedAngle, 0f)

            setAngle(degree)
        } finally {
            a.recycle()
        }
    }

    /**
     * Skew Angle for layout
     * @param degree skew angle
     */
    fun setAngle(degree: Float) {
        tan = Math.tan(degree * pie / 180).toFloat()
        android.util.Log.v("Skew Constraint Layout", "tan::" + tan + "degree" + degree)
        angle = degree
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        mContext = context
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (mContext!!.resources.configuration.layoutDirection == View.LAYOUT_DIRECTION_RTL) {
            //in Right To Left layout
            degree = -tan
            canvas.skew(-tan, 0f)
        } else {
            degree = tan
            canvas.skew(tan, 0f)
        }
        initVar()
    }

    /**
     * Initializing the variable
     */
    fun initVar() {
        x1 = this.x
        y1 = this.y
        w = this.width.toFloat()
        h = this.height.toFloat()
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {

        touchedX = ev.x
        touchedY = ev.y
        val finalX = touchedX - touchedY * degree
        if (finalX > 0 && finalX < w) {
            ev.setLocation(finalX, touchedY)
            return super.dispatchTouchEvent(ev)
        }
        return false
    }


    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        android.util.Log.e(TAG, "-------------onInterceptTouchEvent-----------")
        var needToStop = false
        val touchedX = ev.x
        val touchedY = ev.rawY
        val skewHeight = (touchedY / 8).toInt()
        val v = getChildAt(0).parent as View

        val skewtextleft = getChildAt(0).left + skewHeight
        val skewtextright = getChildAt(0).right + skewHeight

        if (touchedX > skewtextleft + 30) {
            android.util.Log.e("$TAG::", "in If")
            needToStop = true
        } else {
            android.util.Log.e("$TAG::", "in else")
            needToStop = false
        }
        return if (needToStop) {
            false
        } else super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        Log.v(TAG, "-----------onTouchEvent--------------")
        return super.onTouchEvent(ev)
    }

    companion object {
        private val TAG = "SkewConstraintLayout"
    }
}
package com.gm.settingsapp.ui.customview

import android.content.Context
import androidx.core.widget.NestedScrollView
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewConfiguration


class GMNestedScrollView : NestedScrollView {
    private var slop: Int = 0
    private var xDistance: Float = 0.toFloat()
    private var yDistance: Float = 0.toFloat()
    private var lastX: Float = 0.toFloat()
    private var lastY: Float = 0.toFloat()

    constructor(context: Context) : super(context) {
        init(context)
    }

    private fun init(context: Context) {
        val config = ViewConfiguration.get(context)
        slop = config.scaledEdgeSlop
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                yDistance = 0f
                xDistance = yDistance
                lastX = ev.x
                lastY = ev.y
            }
            MotionEvent.ACTION_MOVE -> {
                val curX = ev.x
                val curY = ev.y
                xDistance += Math.abs(curX - lastX)
                yDistance += Math.abs(curY - lastY)
                lastX = curX
                lastY = curY
                if (xDistance > yDistance)
                    return false
            }
        }

        return super.onInterceptTouchEvent(ev) || ev.pointerCount == 2
    }
}
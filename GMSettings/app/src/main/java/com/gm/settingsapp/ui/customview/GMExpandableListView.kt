package com.gm.settingsapp.ui.customview

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.ExpandableListView


class GMExpandableListView(context: Context, attrs: AttributeSet) : ExpandableListView(context, attrs) {

    @SuppressLint("DrawAllocation")
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        var newHeight = 0
        val heightMode = View.MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = View.MeasureSpec.getSize(heightMeasureSpec)
        if (heightMode != View.MeasureSpec.EXACTLY) {
            val listAdapter = adapter
            if (listAdapter != null && !listAdapter.isEmpty) {
                var listPosition = 0
                listPosition = 0
                while (listPosition < listAdapter.count && listPosition < MAXIMUM_LIST_ITEMS_VIEWABLE) {
                    val listItem = listAdapter.getView(listPosition, null, this)
                    //now it will not throw a NPE if listItem is a ViewGroup INSTANCE
                    if (listItem is ViewGroup) {
                        listItem.setLayoutParams(AbsListView.LayoutParams(
                                AbsListView.LayoutParams.WRAP_CONTENT, AbsListView.LayoutParams.WRAP_CONTENT))
                    }
                    listItem.measure(widthMeasureSpec, heightMeasureSpec)
                    newHeight += listItem.measuredHeight
                    listPosition++
                }
                newHeight += dividerHeight * listPosition
            }
            if (heightMode == View.MeasureSpec.AT_MOST && newHeight > heightSize) {
                if (newHeight > heightSize) {
                    newHeight = heightSize
                }
            }
        } else {
            newHeight = measuredHeight
        }
        setMeasuredDimension(measuredWidth, newHeight)
    }

    companion object {
        private val MAXIMUM_LIST_ITEMS_VIEWABLE = 99
    }

}
package com.gm.settingsapp.ui.customview

import android.content.res.Resources
import android.graphics.Color
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import android.widget.LinearLayout
import com.gm.settingsapp.GMSettingsApp.Companion.appContext
import com.gm.settingsapp.R


class GMToast {
    companion object {

        fun displayToast(message: String, gravity: Int) {


            val displayMetrics = Resources.getSystem().displayMetrics
            val screenHeight = displayMetrics.heightPixels
            val screenWidth = displayMetrics.widthPixels

            // val percentWidth =  (screenWidth / 100) * 85
            // val percentHeight =  (screenHeight / 100) * 7

            val toast = Toast.makeText(appContext, message, Toast.LENGTH_SHORT)
            // toast.setGravity(gravity, 120, 125)
            toast.setGravity(gravity, getIntegerById(R.integer.toast_marginStart), getIntegerById(R.integer.toast_marginTop))

            val toastView = toast.view // This'll return the default View of the Toast.
            toastView.elevation = 5f

            // And now you can get the TextView of the default View of the Toast.
            val toastMessage = toastView.findViewById(android.R.id.message) as TextView
//            toastMessage.layoutParams = LinearLayout.LayoutParams(1000, LinearLayout.LayoutParams.WRAP_CONTENT)
            toastMessage.layoutParams = LinearLayout.LayoutParams(getIntegerById(R.integer.toast_width), LinearLayout.LayoutParams.WRAP_CONTENT)
            toastMessage.textSize = 30f
            toastMessage.setTextColor(Color.WHITE)
            // toastMessage.setCompoundDrawablesWithIntrinsicBounds(R.drawable., 0, 0, 0)
            toastMessage.gravity = Gravity.CENTER
            toastMessage.setPadding(16, 16, 16, 16)
            toastView.setBackgroundColor(Color.BLACK)
            toast.show()
        }

        fun getIntegerById(id: Int): Int {
            return appContext.activityContext?.resources?.getInteger(id) ?: 0
        }

    }



}
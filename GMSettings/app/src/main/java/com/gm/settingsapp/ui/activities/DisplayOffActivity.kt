package com.gm.settingsapp.ui.activities

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.Settingsdisplayoffactivitybinding
import com.gm.settingsapp.viewmodels.EventHandler
import com.gm.settingsservice.models.DataPoolDataHandler
import com.gm.settingsservice.utils.Utility
import dagger.android.AndroidInjection

/**
 * This activity is to set display off,on
 */
class DisplayOffActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<Settingsdisplayoffactivitybinding>(this, R.layout.ics_setting_display_off)
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
    }

    /**
     * this fun used for trigger events
     * @param Int passing value,it return keyCode
     * @param KeyEvent passing key event,it return event
     */
    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_BACK, serviceUtility.KEYCODE_GM_TUNE_DOWN, serviceUtility.KEYCODE_GM_TUNE_UP -> {
                finish()
                return super.onKeyUp(keyCode, event)
            }
            else -> return true
        }
    }

    /**
     * this fun used for trigger events
     * @param Int passing value,it return keyCode
     * @param KeyEvent passing key event,it return event
     */
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_BACK, serviceUtility.KEYCODE_GM_TUNE_DOWN, serviceUtility.KEYCODE_GM_TUNE_UP -> {
                finish()
                return super.onKeyUp(keyCode, event)
            }
            else -> return true
        }
    }
}





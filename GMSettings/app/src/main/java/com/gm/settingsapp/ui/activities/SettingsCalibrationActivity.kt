package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.Settingscalibrationactivitybinding
import com.gm.settingsapp.viewmodels.Constants
import dagger.android.AndroidInjection

/**
 * This activity is to set display calibration
 */
class SettingsCalibrationActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        if (dataPoolDataHandler.IS_CADILLAC.get() == false) {
            window.setBackgroundDrawableResource(R.drawable.img_settings_bg)
            setTheme(R.style.AppTheme)
        }
        val binding = setContentSubView(R.layout.ics_setting_calibration_touchscreen) as Settingscalibrationactivitybinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
    }

    override fun onResume() {
        super.onResume()
        //start timer
        eventHandler.calibrationStartTimer(15000, 1000).start()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        eventHandler.processEventByTag(Constants.SETTINGS_CALIBRATION)
    }

    override fun onPause() {
        super.onPause()
        //stop timer
        if (dataPoolDataHandler.CALIBRATE_TIMER != null)
            dataPoolDataHandler.CALIBRATE_TIMER!!.cancel()
    }

}

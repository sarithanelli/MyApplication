package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsPopupFailureBinding
import com.gm.settingsapp.viewmodels.Constants
import dagger.android.AndroidInjection


/**
 * This activity is to set display calibration failure popup
 */
class SettingsCalibrationFailureActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_calibration_popup_failure) as SettingsPopupFailureBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
    }

    override fun onResume() {
        super.onResume()
        headerTitle(getString(R.string.settings_touchscreen_calibration_failed_big))
    }

    override fun onBackPressed() {
        super.onBackPressed()
        eventHandler.processEventByTag(Constants.SETTINGS_CALIBRATION_POPUP)
    }
}

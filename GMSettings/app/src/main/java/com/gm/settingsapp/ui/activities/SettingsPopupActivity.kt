package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsPopupSuccessBinding
import com.gm.settingsapp.viewmodels.Constants
import com.gm.settingsapp.viewmodels.EventHandler
import com.gm.settingsapp.viewmodels.EventProcessor
import com.gm.settingsservice.models.DataPoolDataHandler
import dagger.android.AndroidInjection


/**
 * This activity is to set display calibration success popup
 */
class SettingsPopupActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_popup_display_success) as SettingsPopupSuccessBinding

        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
    }

    override fun onResume() {
        super.onResume()
        headerTitle(getString(R.string.settings_touchscreen_calibration_successful))
    }

    override fun onBackPressed() {
        super.onBackPressed()
        eventHandler.processEventByTag(Constants.SETTINGS_CALIBRATION_POPUP)
    }
}

package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.Settingsdisplayactivitybinding
import com.gm.settingsapp.viewmodels.Constants
import com.gm.settingsapp.viewmodels.Constants.DISPLAYCALIBRATE
import com.gm.settingsapp.viewmodels.Constants.DISPLAYHEADUP
import com.gm.settingsapp.viewmodels.Constants.DISPLAYINSTRUMENT
import com.gm.settingsapp.viewmodels.Constants.DISPLAYMODE
import com.gm.settingsapp.viewmodels.Constants.DISPLAYOFF
import com.gm.settingsapp.viewmodels.Constants.DISPLAYPROXIMITY
import com.gm.settingsapp.viewmodels.Constants.DISPLAYRADIO_DISPLAY
import com.gm.settingsservice.models.DisplayModel
import dagger.android.AndroidInjection

/**
 * This activity is to set display menu
 */
class SettingsDisplayActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {
        if (obj is DisplayModel) {
            dataPoolDataHandler.DISPLAY_CADILLAC_SELECT.set(obj.reference)
            when ((obj).reference) {
                Constants.DISPLAY_MODE -> view.tag = DISPLAYMODE
                Constants.DISPLAY_PROXIMITY -> view.tag = DISPLAYPROXIMITY
                Constants.DISPLAY_CALIBRATE -> view.tag = DISPLAYCALIBRATE
                Constants.DISPLAY_HEAD_UP -> view.tag = DISPLAYHEADUP
                Constants.DISPLAY_INSTRUMENT -> view.tag = DISPLAYINSTRUMENT
                Constants.DISPLAY_RADIO_DISPLAY -> view.tag = DISPLAYRADIO_DISPLAY
            }
        } else {
            view.tag = DISPLAYOFF
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_display) as Settingsdisplayactivitybinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
    }
    override fun onResume() {
        super.onResume()
        headerTitle(getString(R.string.settings_display_big))
    }
}

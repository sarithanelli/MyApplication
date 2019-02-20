package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingPowerLiftgateBinding
import com.gm.settingsapp.databinding.SettingautomaticrunningboardsBinding
import com.gm.settingsapp.databinding.Settingsdisplaymodebinding
import com.gm.settingsapp.viewmodels.Constants
import dagger.android.AndroidInjection

/**
 * This activity is to set display modes Auto,Day,Night
 */
class SettingsVehicleHandFreeLiftgateActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_power_liftgate) as com.gm.settingsapp.databinding.SettingPowerLiftgateBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
    }

    override fun onResume() {
        super.onResume()
        headerTitle(getString(R.string.settings_handsfree_liftgate_control))
    }

    override fun onBackPressed() {
        super.onBackPressed()
        eventHandler.processEventByTag(Constants.COMFORT_AND_CONVENIENCE_TAG)
    }
}

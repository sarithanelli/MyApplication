package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsRideHeightOnOffActivityBinding
import dagger.android.AndroidInjection

class SettingsRideHeightOnOffActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_vehicle_ride_height_on_off) as SettingsRideHeightOnOffActivityBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
    }

    override fun onResume() {
        super.onResume()
        headerTitle(getString(com.gm.settingsapp.R.string.settings_location_based_auto_lift))
    }
}
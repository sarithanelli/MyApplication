package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.R
import dagger.android.AndroidInjection

/**
 * This Activity deals with Driving Modes
 */
class SettingsDrivingModeTractionActivity : BaseActivity() {

    override fun onEventResponse(view: View, obj: Any?) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_vehicle_drivingmode_traction) as com.gm.settingsapp.databinding.VehicleDrivingModeTractionActivityBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
    }
    override fun onResume() {
        super.onResume()
        headerTitle(getString(R.string.settings_traction_big))
    }
}

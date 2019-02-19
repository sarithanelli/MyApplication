package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsVehicleMyModeBrakeActivityBinding
import com.gm.settingsapp.databinding.SettingsVehicleVModeBrakeActivityBinding
import com.gm.settingsapp.databinding.SettingsVehicleVModePowerActivityBinding
import com.gm.settingsapp.viewmodels.Constants
import com.gm.settingsservice.models.MyModeModel
import com.gm.settingsservice.models.VModeModel
import dagger.android.AndroidInjection

/**
 * This Activity deals with different engine sounds
 */
class SettingsVehicleVModePowertrainActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {
        if (obj is Int) {
            dataPoolDataHandler.SETTINGS_VMODE_POWER_TRAIN_POS.set(obj)
            dataPoolDataHandler.SETTINGS_VMODE_MENU [3] = VModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_power_train_engine), resources.getStringArray(R.array.vmode_brake)[obj], Constants.V_MODE_POWER)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_vehicle_vmode_powertrain) as SettingsVehicleVModePowerActivityBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
        dataPoolDataHandler.SETTINGS_VMODE_POWER.clear()
        GMSettingsApp.appContext.resources.getStringArray(R.array.vmode_brake).forEach {
            dataPoolDataHandler.SETTINGS_VMODE_POWER.add(it)
        }    }

    override fun onResume() {
        super.onResume()
        headerTitle(getString(R.string.settings_power_train_engine))

    }
}

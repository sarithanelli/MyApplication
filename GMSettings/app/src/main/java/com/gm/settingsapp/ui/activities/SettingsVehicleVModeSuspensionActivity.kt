package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsVehicleMyModeSuspensionActivityBinding
import com.gm.settingsapp.databinding.SettingsVehicleVModeSuspensionActivityBinding
import com.gm.settingsapp.viewmodels.Constants
import com.gm.settingsservice.models.MyModeModel
import com.gm.settingsservice.models.VModeModel
import dagger.android.AndroidInjection

/**
 * This Activity deals with different engine sounds
 */
class SettingsVehicleVModeSuspensionActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {
        if (obj is Int) {
            dataPoolDataHandler.SETTINGS_MYMODE_SUSPENSION_POS.set(obj)
            dataPoolDataHandler.SETTINGS_VMODE_MENU [2] = VModeModel(GMSettingsApp.appContext.resources.getString(R.string.drive_mode_suspension), resources.getStringArray(R.array.my_mode_suspension)[obj], Constants.V_MODE_SUSPENSION)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_vehicle_vmode_suspension) as SettingsVehicleVModeSuspensionActivityBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
        dataPoolDataHandler.SETTINGS_VMODE_SUSPENSION.clear()
        GMSettingsApp.appContext.resources.getStringArray(R.array.my_mode_suspension).forEach {
            dataPoolDataHandler.SETTINGS_VMODE_SUSPENSION.add(it)
        }    }

    override fun onResume() {
        super.onResume()
        headerTitle(getString(R.string.settings_suspension))

    }
}

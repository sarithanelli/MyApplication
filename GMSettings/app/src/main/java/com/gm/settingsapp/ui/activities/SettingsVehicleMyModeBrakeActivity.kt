package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsVehicleMyModeBrakeActivityBinding
import com.gm.settingsapp.viewmodels.Constants
import com.gm.settingsservice.models.MyModeModel
import dagger.android.AndroidInjection

/**
 * This Activity deals with different engine sounds
 */
class SettingsVehicleMyModeBrakeActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {
        if (obj is Int) {
            dataPoolDataHandler.SETTINGS_MYMODE_BRAKE_POS.set(obj)
            dataPoolDataHandler.SETTINGS_MYMODE_MENU [3] = MyModeModel(GMSettingsApp.appContext.resources.getString(R.string.drive_mode_brakefeel_response), resources.getStringArray(R.array.my_mode_brake)[obj], Constants.MY_MODE_BRAKE)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_mymode_brake_feel) as SettingsVehicleMyModeBrakeActivityBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
        dataPoolDataHandler.SETTINGS_MYMODE_BRAKE.clear()
        GMSettingsApp.appContext.resources.getStringArray(R.array.my_mode_brake).forEach {
            dataPoolDataHandler.SETTINGS_MYMODE_BRAKE.add(it)
        }    }

    override fun onResume() {
        super.onResume()
        headerTitle(getString(R.string.drive_mode_brakefeel_response))

    }
}

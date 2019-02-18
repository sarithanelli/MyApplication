package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsVehicleMyModeSuspensionActivityBinding
import com.gm.settingsapp.viewmodels.Constants
import com.gm.settingsservice.models.MyModeModel
import dagger.android.AndroidInjection

/**
 * This Activity deals with different engine sounds
 */
class SettingsVehicleMyModeSuspensionActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {
        if (obj is Int) {
            dataPoolDataHandler.SETTINGS_MYMODE_SUSPENSION_POS.set(obj)
            dataPoolDataHandler.SETTINGS_MYMODE_MENU [2] = MyModeModel(GMSettingsApp.appContext.resources.getString(R.string.drive_mode_suspension), resources.getStringArray(R.array.my_mode_suspension)[obj], Constants.MY_MODE_SUSPENSION)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_vehicle_mymode_suspension) as SettingsVehicleMyModeSuspensionActivityBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
        dataPoolDataHandler.SETTINGS_MYMODE_SUSPENSION.clear()
        GMSettingsApp.appContext.resources.getStringArray(R.array.my_mode_suspension).forEach {
            dataPoolDataHandler.SETTINGS_MYMODE_SUSPENSION.add(it)
        }    }

    override fun onResume() {
        super.onResume()
        headerTitle(getString(R.string.settings_suspension))

    }
}

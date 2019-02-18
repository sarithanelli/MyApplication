package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.VehicleMyModeEngineSoundActivityBinding
import com.gm.settingsapp.viewmodels.Constants
import com.gm.settingsservice.models.MyModeModel
import dagger.android.AndroidInjection

/**
 * This Activity deals with different engine sounds
 */
class SettingsVehicleMyModeEngineActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {
        if (obj is Int) {
            dataPoolDataHandler.SETTINGS_MYMODE_ENGINE_POS.set(obj)
            dataPoolDataHandler.SETTINGS_MYMODE_MENU[0] = MyModeModel(GMSettingsApp.appContext.resources.getString(R.string.drive_mode_enginesound), resources.getStringArray(R.array.my_mode_engine)[obj], Constants.MY_MODE_ENGINE)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_vehicle_mymode_enginesound) as VehicleMyModeEngineSoundActivityBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
        dataPoolDataHandler.SETTINGS_MYMODE_ENGINE.clear()
        GMSettingsApp.appContext.resources.getStringArray(R.array.my_mode_engine).forEach {
            dataPoolDataHandler.SETTINGS_MYMODE_ENGINE.add(it)
        }    }

    override fun onResume() {
        super.onResume()
        headerTitle(getString(R.string.settings_engine_sound))

    }
}

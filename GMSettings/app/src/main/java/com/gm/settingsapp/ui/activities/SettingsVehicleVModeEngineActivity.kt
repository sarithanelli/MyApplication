package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.VehicleMyModeEngineSoundActivityBinding
import com.gm.settingsapp.databinding.VehicleVModeEngineSoundActivityBinding
import com.gm.settingsapp.viewmodels.Constants
import com.gm.settingsservice.models.MyModeModel
import com.gm.settingsservice.models.VModeModel
import dagger.android.AndroidInjection

/**
 * This Activity deals with different engine sounds
 */
class SettingsVehicleVModeEngineActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {
        if (obj is Int) {
            dataPoolDataHandler.SETTINGS_MYMODE_ENGINE_POS.set(obj)
            dataPoolDataHandler.SETTINGS_VMODE_MENU[0] = VModeModel(GMSettingsApp.appContext.resources.getString(R.string.drive_mode_enginesound), resources.getStringArray(R.array.my_mode_engine)[obj], Constants.V_MODE_ENGINE)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_vehicle_vmode_enginesound) as VehicleVModeEngineSoundActivityBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
        dataPoolDataHandler.SETTINGS_VMODE_ENGINE.clear()
        GMSettingsApp.appContext.resources.getStringArray(R.array.my_mode_engine).forEach {
            dataPoolDataHandler.SETTINGS_VMODE_ENGINE.add(it)
        }    }

    override fun onResume() {
        super.onResume()
        headerTitle(getString(R.string.settings_engine_sound))

    }
}

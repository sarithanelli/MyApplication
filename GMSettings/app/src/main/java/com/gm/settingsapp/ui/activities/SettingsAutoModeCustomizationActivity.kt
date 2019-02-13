package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.VehicleAutoModeCustomizationActivityBinding
import dagger.android.AndroidInjection

/**
 * This activity is to set display calibration
 */
class SettingsAutoModeCustomizationActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {
        when (obj as String) {
            GMSettingsApp.appContext.resources.getString(R.string.ui_normal) -> dataPoolDataHandler.SETTINGS_AUTO_MODE_CUSTOMAIZATION_SELECTION.set(0)
            GMSettingsApp.appContext.resources.getString(R.string.settings_sport_sensitive) -> dataPoolDataHandler.SETTINGS_AUTO_MODE_CUSTOMAIZATION_SELECTION.set(1)
            GMSettingsApp.appContext.resources.getString(R.string.settings_comfort_sensitive) -> dataPoolDataHandler.SETTINGS_AUTO_MODE_CUSTOMAIZATION_SELECTION.set(2)
            GMSettingsApp.appContext.resources.getString(R.string.settings_sport_comfort_sensitive) -> dataPoolDataHandler.SETTINGS_AUTO_MODE_CUSTOMAIZATION_SELECTION.set(3)
            GMSettingsApp.appContext.resources.getString(R.string.settings_sport_comfort_less_sensitive) -> dataPoolDataHandler.SETTINGS_AUTO_MODE_CUSTOMAIZATION_SELECTION.set(4)
            GMSettingsApp.appContext.resources.getString(R.string.settings_auto_adjustment_off) -> dataPoolDataHandler.SETTINGS_AUTO_MODE_CUSTOMAIZATION_SELECTION.set(5)
            GMSettingsApp.appContext.resources.getString(R.string.settings_auto_tour_off) -> dataPoolDataHandler.SETTINGS_AUTO_MODE_CUSTOMAIZATION_SELECTION.set(6)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_vehicle_automode_customization) as VehicleAutoModeCustomizationActivityBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
        dataPoolDataHandler.SETTINGS_AUTO_MODE_CUSTOMAIZATION.clear()
        GMSettingsApp.appContext.resources.getStringArray(R.array.auto_mode_data).forEach {
            dataPoolDataHandler.SETTINGS_AUTO_MODE_CUSTOMAIZATION.add(it)
        }
        GMSettingsApp.appContext.recyclerViewAdapter = null
        dataPoolDataHandler.SETTINGS_AUTO_MODE.set(GMSettingsApp.appContext.resources.getString(R.string.settings_auto_mode_customizations_content))
    }

    override fun onResume() {
        super.onResume()
        headerTitle(GMSettingsApp.appContext.resources.getString(R.string.settings_auto_mode_customization))
    }
}
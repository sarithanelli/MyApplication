package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsDriveModeCustomizationActivityBinding
import com.gm.settingsapp.viewmodels.Constants.MY_MODE
import com.gm.settingsapp.viewmodels.Constants.VISUALIZATION
import com.gm.settingsapp.viewmodels.Constants.V_MODE_Z_MODE
import com.gm.settingsservice.models.DriveModeCustomizationModel
import dagger.android.AndroidInjection

/**
 * Activity for displaying Driving Mode List
 */
class SettingsDriveModeCustomizationActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_vehicle_drive_mode_customization) as SettingsDriveModeCustomizationActivityBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
        dataPoolDataHandler.SETTINGS_DRIVEMODE_CUSTOMIZATION_MENU.clear()

        dataPoolDataHandler.SETTINGS_DRIVEMODE_CUSTOMIZATION_MENU.add(DriveModeCustomizationModel(GMSettingsApp.appContext.resources.getString(R.string.settings_vmode),  V_MODE_Z_MODE))
        dataPoolDataHandler.SETTINGS_DRIVEMODE_CUSTOMIZATION_MENU.add(DriveModeCustomizationModel(GMSettingsApp.appContext.resources.getString(R.string.settings_mymode),  MY_MODE))
        dataPoolDataHandler.SETTINGS_DRIVEMODE_CUSTOMIZATION_MENU.add(DriveModeCustomizationModel(GMSettingsApp.appContext.resources.getString(R.string.visualization),  VISUALIZATION))
    }


    override fun onResume() {
        super.onResume()
        headerTitle(getString(com.gm.settingsapp.R.string.settings_drive_mode_customization))
    }

    override fun onEventResponse(view: View, obj: Any?) {

        }
    }

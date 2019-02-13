package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsDrivingModebinding
import com.gm.settingsapp.viewmodels.Constants
import com.gm.settingsapp.viewmodels.Constants.DRIVEMODE_ENGINE
import com.gm.settingsapp.viewmodels.Constants.DRIVEMODE_STEERING
import com.gm.settingsapp.viewmodels.Constants.DRIVEMODE_SUSPENSION
import com.gm.settingsapp.viewmodels.Constants.DRIVEMODE_TRACTION
import com.gm.settingsservice.models.DriveModeModel
import dagger.android.AndroidInjection

/**
 * Activity for displaying Driving Mode List
 */
class SettingsDrivingModeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_vehicle_driving_mode) as SettingsDrivingModebinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
    }

    override fun onResume() {
        super.onResume()
        headerTitle(getString(com.gm.settingsapp.R.string.settings_driving_mode_big))
    }

    override fun onEventResponse(view: View, obj: Any?) {
        when ((obj as DriveModeModel).reference) {
            Constants.DRIVE_MODE_ENGINE_SOUND -> view.tag = DRIVEMODE_ENGINE
            Constants.DRIVE_MODE_STEERING -> view.tag = DRIVEMODE_STEERING
            Constants.DRIVE_MODE_SUSPENSION -> view.tag = DRIVEMODE_SUSPENSION
            Constants.DRIVE_MODE_TRACTION -> view.tag = DRIVEMODE_TRACTION
        }
    }
}
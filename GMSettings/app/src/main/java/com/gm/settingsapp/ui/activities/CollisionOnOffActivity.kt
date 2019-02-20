package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.RearCameraParkAssistSymbolsActivityBinding
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
class CollisionOnOffActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_rear_camera_park_assist_symbols) as RearCameraParkAssistSymbolsActivityBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
    }

    override fun onResume() {
        super.onResume()
        headerTitle(dataPoolDataHandler.SETTINGS_COLLISION_HEADER_TEXT.get()!!)
    }
}
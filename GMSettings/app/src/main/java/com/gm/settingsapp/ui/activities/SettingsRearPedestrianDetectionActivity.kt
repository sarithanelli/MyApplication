package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsRearPedestrianDetectionActivityBinding
import com.gm.settingsapp.viewmodels.Constants
import com.gm.settingsservice.models.CollisionModeModel
import com.gm.settingsservice.models.MyModeModel
import dagger.android.AndroidInjection

/**
 * Activity for displaying Driving Mode List
 */
class SettingsRearPedestrianDetectionActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {
        if (obj is Int) {
            dataPoolDataHandler.SETTINGS_COLLISION_RECYCLER_VIEW.set(obj)
    }
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_rear_pedestrian_detection) as SettingsRearPedestrianDetectionActivityBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
        dataPoolDataHandler.SETTINGS_PEDESTRIAN_DETECTION.clear()
        GMSettingsApp.appContext.resources.getStringArray(R.array.pedestrian_detection).forEach {
            dataPoolDataHandler.SETTINGS_PEDESTRIAN_DETECTION.add(it)
        }
    }
    override fun onResume() {
        super.onResume()
        headerTitle(getString(com.gm.settingsapp.R.string.settings_collision))
    }
}
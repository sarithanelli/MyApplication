package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import android.widget.ToggleButton
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SportModeListActivityBinding
import com.gm.settingsapp.viewmodels.Constants.SPORT_ADAPTIVE
import com.gm.settingsapp.viewmodels.Constants.SPORT_DISPLAY
import com.gm.settingsapp.viewmodels.Constants.SPORT_DRIVER_SEAT
import com.gm.settingsapp.viewmodels.Constants.SPORT_PASSANGER_SEAT
import com.gm.settingsapp.viewmodels.Constants.SPORT_STEERING
import com.gm.settingsapp.viewmodels.Constants.SPORT_SUSPENSION
import com.gm.settingsapp.viewmodels.Constants.SPORT_TAG
import com.gm.settingsapp.viewmodels.Constants.SPORT_TRACTION
import com.gm.settingsapp.viewmodels.EventHandler
import com.gm.settingsservice.models.DataPoolDataHandler
import com.gm.settingsservice.models.SportModeModel
import dagger.android.AndroidInjection

/**
 * Activity to display sport mode customization options list
 */
class SettingsSportModeCustomizationActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {
        view.tag = SPORT_TAG
        if (view is ToggleButton) {
            val value = obj as SportModeModel
            when (value.primaryData) {
                GMSettingsApp.appContext.resources.getString(R.string.settings_sport_steering_big)
                -> view.tag = SPORT_STEERING

                GMSettingsApp.appContext.resources.getString(R.string.settings_sport_display_big)
                -> view.tag = SPORT_DISPLAY

                GMSettingsApp.appContext.resources.getString(R.string.settings_sport_suspension_big)
                -> view.tag = SPORT_SUSPENSION

                GMSettingsApp.appContext.resources.getString(R.string.settings_sport_awd_big)
                -> view.tag = SPORT_TRACTION

                GMSettingsApp.appContext.resources.getString(R.string.settings_sport_driver_seat_big)
                -> view.tag = SPORT_DRIVER_SEAT

                GMSettingsApp.appContext.resources.getString(R.string.settings_sport_passenger_seat_big)
                -> view.tag = SPORT_PASSANGER_SEAT

                GMSettingsApp.appContext.resources.getString(R.string.settings_sport_adaptive_cruise_control_big)
                -> view.tag = SPORT_ADAPTIVE
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_vehicle_sportmode_customization) as SportModeListActivityBinding

        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }

    }

    override fun onResume() {
        super.onResume()
        headerTitle(getString(R.string.settings_sport_mode_customization))
    }
}
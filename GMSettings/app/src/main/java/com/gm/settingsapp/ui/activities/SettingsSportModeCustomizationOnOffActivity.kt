package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsSportmodeOptimisationOnOff
import com.gm.settingsapp.viewmodels.Constants.SPORT_ADAPTIVE
import com.gm.settingsapp.viewmodels.Constants.SPORT_DISPLAY
import com.gm.settingsapp.viewmodels.Constants.SPORT_DRIVER_SEAT
import com.gm.settingsapp.viewmodels.Constants.SPORT_PASSANGER_SEAT
import com.gm.settingsapp.viewmodels.Constants.SPORT_STEERING
import com.gm.settingsapp.viewmodels.Constants.SPORT_SUSPENSION
import com.gm.settingsapp.viewmodels.Constants.SPORT_TRACTION
import dagger.android.AndroidInjection

/**
 * This class used for view the list of sport modes
 */
class SettingsSportModeCustomizationOnOffActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {
        when (dataPoolDataHandler.SETTINGS_HEADERTITLE_NAME.get()) {
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

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_sportmode_optimisation_on_off) as SettingsSportmodeOptimisationOnOff

        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
    }

    override fun onResume() {
        super.onResume()

    }
}


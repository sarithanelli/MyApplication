package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import android.widget.ToggleButton
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsClimatedatabinging
import com.gm.settingsapp.viewmodels.Constants.AIR_QUALITY_SENSOR
import com.gm.settingsapp.viewmodels.Constants.AIR_QUALITY_SENSOR_TAG
import com.gm.settingsapp.viewmodels.Constants.AUTO_AIR_DISTRIBUTION
import com.gm.settingsapp.viewmodels.Constants.AUTO_AIR_DISTRIBUTION_TAG
import com.gm.settingsapp.viewmodels.Constants.AUTO_COOLED_SEATS
import com.gm.settingsapp.viewmodels.Constants.AUTO_COOLED_SEATS_TAG
import com.gm.settingsapp.viewmodels.Constants.AUTO_DEFOG
import com.gm.settingsapp.viewmodels.Constants.AUTO_DEFOG_TAG
import com.gm.settingsapp.viewmodels.Constants.AUTO_FAN_SPEED
import com.gm.settingsapp.viewmodels.Constants.AUTO_FAN_SPEED_TAG
import com.gm.settingsapp.viewmodels.Constants.AUTO_HEATED_SEATS
import com.gm.settingsapp.viewmodels.Constants.AUTO_HEATED_SEATS_TAG
import com.gm.settingsapp.viewmodels.Constants.CLIMATE_ON_OF
import com.gm.settingsapp.viewmodels.Constants.IONIZER
import com.gm.settingsapp.viewmodels.Constants.IONIZER_TAG
import com.gm.settingsapp.viewmodels.Constants.POLLUTION_CONTROL
import com.gm.settingsapp.viewmodels.Constants.POLLUTION_CONTROL_TAG
import com.gm.settingsservice.models.ClimateModeModel
import dagger.android.AndroidInjection

/**
 * To display Climate options/settings
 */
class SettingsClimateActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_climate_list) as SettingsClimatedatabinging
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
    }

    override fun onResume() {
        super.onResume()
        headerTitle(GMSettingsApp.appContext.resources.getString(R.string.ui_climate))
    }

    override fun onEventResponse(view: View, obj: Any?) {
        if (view is ToggleButton) {
            when ((obj as ClimateModeModel).reference) {
                POLLUTION_CONTROL -> view.tag = POLLUTION_CONTROL_TAG
                AUTO_COOLED_SEATS -> view.tag = AUTO_COOLED_SEATS_TAG
                AUTO_HEATED_SEATS -> view.tag = AUTO_HEATED_SEATS_TAG
                AUTO_DEFOG -> view.tag = AUTO_DEFOG_TAG
                IONIZER -> view.tag = IONIZER_TAG
            }
        } else {
            view.tag = CLIMATE_ON_OF
            when ((obj as ClimateModeModel).reference) {
                AUTO_FAN_SPEED -> view.tag = AUTO_FAN_SPEED_TAG
                AIR_QUALITY_SENSOR -> view.tag = AIR_QUALITY_SENSOR_TAG
                AUTO_AIR_DISTRIBUTION -> view.tag = AUTO_AIR_DISTRIBUTION_TAG
            }
        }
    }


}


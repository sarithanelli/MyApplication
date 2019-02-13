package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsClimateOnOff
import com.gm.settingsapp.viewmodels.Constants.AUTO_COOLED_SEATS
import com.gm.settingsapp.viewmodels.Constants.AUTO_COOLED_SEATS_TAG
import com.gm.settingsapp.viewmodels.Constants.AUTO_DEFOG
import com.gm.settingsapp.viewmodels.Constants.AUTO_DEFOG_TAG
import com.gm.settingsapp.viewmodels.Constants.AUTO_HEATED_SEATS
import com.gm.settingsapp.viewmodels.Constants.AUTO_HEATED_SEATS_TAG
import com.gm.settingsapp.viewmodels.Constants.IONIZER
import com.gm.settingsapp.viewmodels.Constants.IONIZER_TAG
import com.gm.settingsapp.viewmodels.Constants.POLLUTION_CONTROL
import com.gm.settingsapp.viewmodels.Constants.POLLUTION_CONTROL_TAG
import dagger.android.AndroidInjection

/**
 * Activity to display settings climate on/off options list
 */
class SettingsClimateOnOffActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {

        when (dataPoolDataHandler.SETTINGS_SET_CLIMATE_INNER_REF.get()) {
            POLLUTION_CONTROL -> view.tag = POLLUTION_CONTROL_TAG
            AUTO_COOLED_SEATS -> view.tag = AUTO_COOLED_SEATS_TAG
            AUTO_HEATED_SEATS -> view.tag = AUTO_HEATED_SEATS_TAG
            AUTO_DEFOG -> view.tag = AUTO_DEFOG_TAG
            IONIZER -> view.tag = IONIZER_TAG
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_climate_on_of) as SettingsClimateOnOff
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
    }

    override fun onResume() {
        super.onResume()
        headerTitle(dataPoolDataHandler.SETTINGS_SET_CLIMATE_INNER_TITLE.get().toString())
    }

}
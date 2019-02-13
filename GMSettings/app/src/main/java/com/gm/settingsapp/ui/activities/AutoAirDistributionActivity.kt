package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.AutoAirDistributionDataBinding
import dagger.android.AndroidInjection

/**
 * Activity to display Auto Air distribution options list
 */
class AutoAirDistributionActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {
        if (obj is Boolean) {


        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_auto_air_distribution_settings) as AutoAirDistributionDataBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
    }

    override fun onResume() {
        super.onResume()
        headerTitle(GMSettingsApp.appContext.resources.getString(R.string.settings_auto_air_distribution_big))
    }
}
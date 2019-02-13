package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.AutomaticTimeZoneActivityBinding
import dagger.android.AndroidInjection


/**
 * To check and display Automatic Time Zone availability
 */
class SettingsAutomaticTimeZoneActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_setting_automatic_timezone) as AutomaticTimeZoneActivityBinding

        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
    }

    override fun onResume() {
        super.onResume()
        headerTitle(GMSettingsApp.appContext.resources.getString(R.string.settings_automatic_timezone_unavailable))
    }
}

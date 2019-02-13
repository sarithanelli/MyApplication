package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.R
import com.gm.settingsapp.viewmodels.Constants
import dagger.android.AndroidInjection

/**
 *This Activity Launch when user interacts with Android_Auto, Apple_CarPlay, Mirror_Link options from Settings->Apps
 */
class SettingsAppsOnOffActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {

        when (dataPoolDataHandler.SETTINGS_SET_APPS_INNER_REF.get()) {
            Constants.ANDROID_AUTO -> view.tag = Constants.ANDROID_AUTO_TAG
            Constants.MIRROR_LINK -> view.tag = Constants.ANDROID_AUTO_TAG
            Constants.APPLE_CARPLAY -> view.tag = Constants.APPLE_CARPLAY_TAG
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_apps_on_off) as com.gm.settingsapp.databinding.SettingsAppsOnOffBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }

    }

    override fun onResume() {
        super.onResume()
        headerTitle(dataPoolDataHandler.SETTINGS_SET_APPS_INNER_TITLE.get().toString())
    }
}
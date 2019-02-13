package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.AboutBuildNumberBinding
import dagger.android.AndroidInjection

/*
 * This activity launch About BuildNumeber Screen
 */
class SettingsAboutBuildNumberActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.uil_settings_about_build_number_tab) as AboutBuildNumberBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
    }

    override fun onResume() {
        super.onResume()
        headerTitle(GMSettingsApp.appContext.resources.getString(R.string.updater_about))
    }
}

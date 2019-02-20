package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.R
import dagger.android.AndroidInjection
import com.gm.settingsapp.databinding.SettingsVisualizationBinding

class SettingsDriveModeVisualizationActivity : BaseActivity() {

    override fun onEventResponse(view: View, obj: Any?) {
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        val binding = setContentSubView(R.layout.ics_settings_visualization) as SettingsVisualizationBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
    }

    override fun onResume() {
        super.onResume()
        headerTitle(getString(com.gm.settingsapp.R.string.visualization))
    }

}
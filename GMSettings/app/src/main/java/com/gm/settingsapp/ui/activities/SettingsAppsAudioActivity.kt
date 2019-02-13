package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsservice.models.AudioModeModel
import dagger.android.AndroidInjection

/**
 * This Activity opens the Audio App Installed in the Hardware
 */
class SettingsAppsAudioActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_apps_audio_fragment) as com.gm.settingsapp.databinding.SettingsAppsAudioBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
        audioData()
    }

    override fun onResume() {
        super.onResume()
        headerTitle(GMSettingsApp.appContext.resources.getString(R.string.ui_audio_small))
        if (dataPoolDataHandler.SETTINGS_SYSTEMS_APPS_AUDIO_DATA.size > 0)
            dataPoolDataHandler.SETTINGS_SYSTEMS_APPS_AUDIO_DATA[3] = AudioModeModel(resources.getString(R.string.apps_audio_set_number_of), "" + dataPoolDataHandler.SETTINGS_CURRENT_NUMBER_FAVORITES.get(), false, false, true)
    }

    private fun audioData() {
        dataPoolDataHandler.SETTINGS_SYSTEMS_APPS_AUDIO_DATA.clear()

        resources.getStringArray(R.array.app_audio_data).forEach {
            when (it) {
                resources.getString(R.string.apps_audio_set_number_of) -> dataPoolDataHandler.SETTINGS_SYSTEMS_APPS_AUDIO_DATA.add(AudioModeModel(it, "" + dataPoolDataHandler.SETTINGS_CURRENT_NUMBER_FAVORITES.get(), false, false, false))
                resources.getString(R.string.apps_audio_traffic_program) -> dataPoolDataHandler.SETTINGS_SYSTEMS_APPS_AUDIO_DATA.add(AudioModeModel(resources.getString(R.string.apps_audio_traffic_program), "", true, true, false))
                resources.getString(R.string.apps_audio_rds) -> dataPoolDataHandler.SETTINGS_SYSTEMS_APPS_AUDIO_DATA.add(AudioModeModel(resources.getString(R.string.apps_audio_rds), "", true, true, false))
                else -> dataPoolDataHandler.SETTINGS_SYSTEMS_APPS_AUDIO_DATA.add(AudioModeModel(it, "", false, false, false))
            }
        }

    }


}
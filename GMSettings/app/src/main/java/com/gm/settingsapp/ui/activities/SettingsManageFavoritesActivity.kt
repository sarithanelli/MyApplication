package com.gm.settingsapp.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsAudioFavoritesFragmentBinding
import dagger.android.AndroidInjection

/**
 * This Activity opens "Installed favorites app"
 */
@SuppressLint("Registered")
class SettingsManageFavoritesActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_set_audio_favorites) as SettingsAudioFavoritesFragmentBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
    }

    override fun onResume() {
        super.onResume()
        headerTitle(getString(R.string.settings_set_number_of_audio_favorites))
    }
}
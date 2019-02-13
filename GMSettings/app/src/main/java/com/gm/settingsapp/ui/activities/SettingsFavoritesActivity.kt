package com.gm.settingsapp.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsFavoritesMenuFragmentBinding
import dagger.android.AndroidInjection

/**
 * This activity is used to set no of audio favorites into an limit
 */
@SuppressLint("Registered")
class SettingsFavoritesActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_system_favorites) as SettingsFavoritesMenuFragmentBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
    }

    override fun onResume() {
        super.onResume()
        //set mode title
        headerTitle(getString(R.string.settings_favorites_big))
    }
}
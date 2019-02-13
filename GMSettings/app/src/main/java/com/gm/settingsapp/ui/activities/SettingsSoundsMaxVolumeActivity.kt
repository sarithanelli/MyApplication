package com.gm.settingsapp.ui.activities


import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SoundsMaxVolumeActivityBinding
import dagger.android.AndroidInjection

/*
 * This activity launch Sounds MaxVolume Screen
 */
class SettingsSoundsMaxVolumeActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_system_sounds_maxstartupvol) as SoundsMaxVolumeActivityBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
    }

    override fun onResume() {
        super.onResume()
        headerTitle(GMSettingsApp.appContext.resources.getString(R.string.settings_maximum_startup_volume))
    }


}

package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettindsOnOffSoundsShuttdownSounds
import dagger.android.AndroidInjection

/**
 * This screen is to enable or disable the options like use 24-hour format, Automatic time update
 */
class SettingsOnOffActivitySounds : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {
        if (obj is Boolean) {
            dataPoolDataHandler.SETTINGS_REQ_SOUNDDATAOBJ.get()!!.isToggleState = obj
            dataPoolDataHandler.SETTINGS_REQ_SOUNDDATA[dataPoolDataHandler.SETTINGS_REQ_SOUNDDATAOBJ.get()!!.tPosition] = dataPoolDataHandler.SETTINGS_REQ_SOUNDDATAOBJ.get()!!
            if (dataPoolDataHandler.SETTINGS_REQ_SOUNDDATAOBJ.get()!!.tPosition == 1)
                dataPoolDataHandler.SETTINGS_STARTUP_SHUTDOWN_SOUNDS.set(obj)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_sounds_on_off) as SettindsOnOffSoundsShuttdownSounds
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
    }

    override fun onResume() {
        super.onResume()
        headerTitle(dataPoolDataHandler.SETTINGS_REQ_SOUNDDATAOBJ.get()!!.name)
    }

}
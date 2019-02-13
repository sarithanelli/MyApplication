package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import android.widget.ToggleButton
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SoundsListActivityBinding
import com.gm.settingsservice.models.GMSoundMenu
import dagger.android.AndroidInjection

/**
 * Created by Salmon on 10/29/2018.
 * To change sound mode settings
 */
/*
 * This activity launch Sounds Screen
 */
class SettingsSoundsActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {

        when (obj) {
            is GMSoundMenu -> {
                if (view is ToggleButton) {
                    obj.isToggleState = view.isChecked
                    dataPoolDataHandler.SETTINGS_REQ_SOUNDDATA[obj.tPosition] = GMSoundMenu(obj.name, obj.isTogglevisible, obj.isToggleState, obj.tPosition, obj.description)
                    if (obj.tPosition == 1)
                        dataPoolDataHandler.SETTINGS_STARTUP_SHUTDOWN_SOUNDS.set(obj.isToggleState)

                } else if (obj.tPosition == 1 || obj.tPosition == 3) {
                    dataPoolDataHandler.SETTINGS_REQ_SOUNDDATAOBJ.set(obj)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_system_sounds) as SoundsListActivityBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
    }

    override fun onResume() {
        super.onResume()
        headerTitle(GMSettingsApp.appContext.resources.getString(R.string.settings_sounds_header))
    }


}
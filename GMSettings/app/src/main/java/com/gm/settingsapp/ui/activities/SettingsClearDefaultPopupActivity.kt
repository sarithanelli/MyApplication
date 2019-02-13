package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsClearDefaultPopupBinding
import dagger.android.AndroidInjection


/**
 * This activity is to set display clear default popup
 */
class SettingsClearDefaultPopupActivity: BaseActivity()
{
    override fun onEventResponse(view: View, obj: Any?) {


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        if (dataPoolDataHandler.IS_CADILLAC.get() == false) {
            window.setBackgroundDrawableResource(R.drawable.img_settings_bg)
            setTheme(R.style.AppTheme)
        }
        val binding=setContentSubView(R.layout.ics_settings_clear_default_popup) as SettingsClearDefaultPopupBinding
        binding.let{
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }

        dataPoolDataHandler.SETTINGS_FACTORY_WARNING.set(GMSettingsApp.appContext.resources.getString(R.string.settings_clear_defaults_apps_popup_content))
        //Utility.cadillacPopup(window)
    }

    override fun onResume() {
        super.onResume()
        dataPoolDataHandler.SETTINGS_HEADERTITLE_NAME.set(GMSettingsApp.appContext.resources.
                getString(R.string.settings_clear_default_applications))

    }

}
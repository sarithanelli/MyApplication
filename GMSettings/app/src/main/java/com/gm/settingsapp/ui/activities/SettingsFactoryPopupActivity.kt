package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsFactoryPopupBinding
import dagger.android.AndroidInjection

/**
 * Used to display popup for Return to Factory Settings
 */
class SettingsFactoryPopupActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        if (dataPoolDataHandler.IS_CADILLAC.get() == false) {
            window.setBackgroundDrawableResource(R.drawable.img_settings_bg)
            setTheme(R.style.AppTheme)
        }
        val binding = setContentSubView(R.layout.ics_settings_factory_popup) as SettingsFactoryPopupBinding
        binding.let {
            it.clickHandler = eventHandler
            it.dataPoolHandler = dataPoolDataHandler
        }
        dataPoolDataHandler.SETTINGS_FACTORY_WARNING.set(GMSettingsApp.appContext.resources.getString(R.string.settings_warning_content1))
        //Utility.cadillacPopup(window)
    }

    override fun onResume() {
        super.onResume()
        dataPoolDataHandler.SETTINGS_HEADERTITLE_NAME.set(GMSettingsApp.appContext.resources.getString(R.string.ui_warning_long))

    }

}
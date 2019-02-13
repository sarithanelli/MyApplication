package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.RunningPopupSettingsBinding
import dagger.android.AndroidInjection

/**
 * This activity is used to display popup (Running Application)
 */
class RunningsAppsPopupSettingsActivity : BaseActivity() {

    override fun onEventResponse(view: View, obj: Any?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        if (dataPoolDataHandler.IS_CADILLAC.get() == false) {
            window.setBackgroundDrawableResource(R.drawable.img_settings_bg)
            setTheme(R.style.AppTheme)
        }
        val binding = setContentSubView(R.layout.ics_running_apps_settings_popup) as RunningPopupSettingsBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
        dataPoolDataHandler.SETTINGS_HEADERTITLE_NAME.set(GMSettingsApp.appContext.resources.getString(R.string.ui_warning_long_hd))
        //cadillacPopup(window)
    }

    override fun onResume() {
        super.onResume()
    }
}

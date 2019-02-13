package com.gm.settingsapp.ui.activities

import android.app.ActivityManager
import android.content.Context
import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsRunningAppsActivitybinding
import dagger.android.AndroidInjection

/**
 * This activity is used to stop running applications.
 */
class RunningAppsSettingsActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_running_apps_settings) as SettingsRunningAppsActivitybinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
        val actvityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val sizels = actvityManager.runningAppProcesses.size
        actvityManager.runningAppProcesses
    }

    override fun onResume() {
        super.onResume()
        dataPoolDataHandler.SETTINGS_HEADERTITLE_NAME.set(GMSettingsApp.appContext.resources.getString(R.string.settings_running_applications))
    }
}
